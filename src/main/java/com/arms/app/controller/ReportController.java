package com.arms.app.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView;

import com.arms.app.util.ConstantaVariable;
import com.arms.app.util.StringUtil;

/*import net.sf.jasperreports.engine.DefaultJasperReportsContext;
import net.sf.jasperreports.engine.JRPropertiesUtil;
import oracle.jdbc.pool.OracleDataSource;*/

@Controller
@RequestMapping("/cetak")
public class ReportController {

	@Autowired
	DataSource datasource;
	
	String TESTING = "report/testing.jasper";
	
	@Autowired
	private ApplicationContext context;
	
//	@Value("${progmod.oracle.driver-type}")
	private String driverType;
	
//	@Value("${progmod.oracle.server-name}")
	private String serverName;
	
//	@Value("${progmod.oracle.port-number}")
	private Integer portNumber;
	
//	@Value("${progmod.oracle.database-name}")
	private String databaseName;
	
//	@Value("${progmod.oracle.username}")
	private String userName;
	
//	@Value("${progmod.oracle.password}")
	private String password;
	
	
	/*public DataSource getDS() throws SQLException{
//		Class.forName(className);
//	 	Connection connection = null;
//	 	connection = DriverManager.getConnection(url,username,password);
	 	
	 	DataSource ds = new OracleDataSource();// There is other DataSource offered by Oracle , check the javadoc for more information
	 	((OracleDataSource) ds).setDriverType(driverType);
	 	((OracleDataSource) ds).setServerName(serverName);
	 	((OracleDataSource) ds).setPortNumber(portNumber);
	 	((OracleDataSource) ds).setDatabaseName(databaseName);
	 	((OracleDataSource) ds).setUser(userName);
	 	((OracleDataSource) ds).setPassword(password);
	 	 
	 	return ds;
	}
//	
//	
//	
	@RequestMapping(path = "/test", method = RequestMethod.GET)
	@ResponseBody
	public String test() {

	    return "berhasil";
	}
	
	@RequestMapping(path = "/lpadbps", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView cetakLPADBPS(HttpServletResponse response, @RequestParam(value = "no_lpad") String no_lpad) throws SQLException{
		JasperReportsPdfView view = new JasperReportsPdfView();
		
		DataSource DS = getDS();
		view.setJdbcDataSource(DS);
		view.setUrl("classpath:" + ConstantaVariable.Cetak.LPADBPS); 
		view.setApplicationContext(context);
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("P_LPAD", no_lpad);

	    return new ModelAndView(view, params);
	}
	
	@RequestMapping(path = "/lampiranSuratKeberatan", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView cetakLampiranSuratKeberatan(HttpServletResponse response, @RequestParam(value = "no_lpad") String no_lpad) throws SQLException{
		JasperReportsPdfView view = new JasperReportsPdfView();
		
		DefaultJasperReportsContext jasperContext = DefaultJasperReportsContext.getInstance();
		JRPropertiesUtil.getInstance(jasperContext).setProperty("net.sf.jasperreports.default.pdf.embedded", "true");
		
		DataSource DS = getDS();
		view.setJdbcDataSource(DS);
		view.setUrl("classpath:" + ConstantaVariable.Cetak.LAMPIRAN_SURAT_KEBERATAN); 
		view.setApplicationContext(context);
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("P_LPAD", no_lpad);

	    return new ModelAndView(view, params);
	}
	
	@RequestMapping(path = "/lembarkelengkapanberkas", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView cetakKelengkapanBerkas(HttpServletResponse response, @RequestParam(value = "no_lpad") String no_lpad) throws SQLException{
		JasperReportsPdfView view = new JasperReportsPdfView();
		
		DataSource DS = getDS();
		view.setJdbcDataSource(DS);
		view.setUrl("classpath:" + ConstantaVariable.Cetak.LEMBAR_ISIAN_KELENGKAPAN_BERKAS); 
		view.setApplicationContext(context);
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("P_LPAD", no_lpad);

	    return new ModelAndView(view, params);
	}
	
	@RequestMapping(path = "/lembarpengawasanpenelitian", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView cetakPengwasanPenelitian(HttpServletResponse response, @RequestParam(value = "no_lpad") String no_lpad) throws SQLException{
		JasperReportsPdfView view = new JasperReportsPdfView();
		
		DataSource DS = getDS();
		view.setJdbcDataSource(DS);
		view.setUrl("classpath:" + ConstantaVariable.Cetak.LEMBAR_PENGAWASAN_PENELITIAN); 
		view.setApplicationContext(context);
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("P_LPAD", no_lpad);

	    return new ModelAndView(view, params);
	}
	
	@RequestMapping(path = "/suratpengantar", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView cetakSuratPengatar(HttpServletResponse response, @RequestParam(value = "no_surat_pengantar") String noSuratPengantar) throws SQLException{
		JasperReportsPdfView view = new JasperReportsPdfView();
		
		DataSource DS = getDS();
		view.setJdbcDataSource(DS);
		view.setUrl("classpath:" + ConstantaVariable.Cetak.SURAT_PENGANTAR); 
		view.setApplicationContext(context);
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("P_NO_SURAT_PENGANTAR", noSuratPengantar);

	    return new ModelAndView(view, params);
	}
	
	@RequestMapping(path = "/surattugas", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView cetakSuratTugas(HttpServletResponse response, @RequestParam(value = "no_surat_tugas") String noSuratTugas) throws SQLException{
		JasperReportsPdfView view = new JasperReportsPdfView();
		
		DataSource DS = getDS();
		view.setJdbcDataSource(DS);
		view.setUrl("classpath:" + ConstantaVariable.Cetak.SURAT_TUGAS); 
		view.setApplicationContext(context);
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("P_NO_SURAT_TUGAS", noSuratTugas);

	    return new ModelAndView(view, params);
	}
	
	@RequestMapping(path = "/penelitiansyarat", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView cetakPenelitianSyarat(HttpServletResponse response, @RequestParam(value = "no_lpad") String noLPAD) throws SQLException{
		JasperReportsPdfView view = new JasperReportsPdfView();
		
		DataSource DS = getDS();
		view.setJdbcDataSource(DS);
		view.setUrl("classpath:" + ConstantaVariable.Cetak.LEMBAR_PENELITIAN_SYARAT); 
		view.setApplicationContext(context);
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("P_NO_LPAD", noLPAD);

	    return new ModelAndView(view, params);
	}
	
	@RequestMapping(path = "/tidakmemenuhisyarat", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView cetakTidakMemenuhiSyarat(HttpServletResponse response, @RequestParam(value = "no_lpad") String noLPAD) throws SQLException{
		JasperReportsPdfView view = new JasperReportsPdfView();
		
		DataSource DS = getDS();
		view.setJdbcDataSource(DS);
		view.setUrl("classpath:" + ConstantaVariable.Cetak.SURAT_TIDAK_MEMENUHI_SYARAT); 
		view.setApplicationContext(context);
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("P_NO_LPAD", noLPAD);

	    return new ModelAndView(view, params);
	}
	
	@RequestMapping(path = "/surathadir", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView cetakSuratHadir(HttpServletResponse response, @RequestParam(value = "no_lpad") String noLPAD) throws SQLException{
		JasperReportsPdfView view = new JasperReportsPdfView();
		
		DataSource DS = getDS();
		view.setJdbcDataSource(DS);
		view.setUrl("classpath:" + ConstantaVariable.Cetak.SURAT_HADIR); 
		view.setApplicationContext(context);
		String path = StringUtil.getPathbyOS("report/");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("P_NO_LPAD", noLPAD);
		params.put("PATH", path);
	    return new ModelAndView(view, params);
	}
	
	@RequestMapping(path = "/suratkeputusan", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView cetakSuratKeputusan(HttpServletResponse response, @RequestParam(value = "no_lpad") String noLPAD, @RequestParam(value = "group_flag") String groupFlag) throws SQLException{
		JasperReportsPdfView view = new JasperReportsPdfView();
		String path = StringUtil.getPathbyOS("report/");
		 
		DataSource DS = getDS();
		view.setJdbcDataSource(DS);
		view.setUrl("classpath:" + ConstantaVariable.Cetak.SURAT_KEBERATAN); 
		view.setApplicationContext(context);
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("P_NO_LPAD", noLPAD);
		params.put("GROUP_FLAG", groupFlag);
		params.put("PATH", path);

	    return new ModelAndView(view, params);
	}
	
	
	@RequestMapping(path = "/stpengganti", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView cetakSTPengganti(HttpServletResponse response, @RequestParam(value = "no_surat_tugas") String noSuratTugas) throws SQLException{
		JasperReportsPdfView view = new JasperReportsPdfView();
		String path = StringUtil.getPathbyOS("report/");
		 
		DataSource DS = getDS();
		view.setJdbcDataSource(DS);
		view.setUrl("classpath:" + ConstantaVariable.Cetak.SURAT_TUGAS_PENGGANTI); 
		view.setApplicationContext(context);
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("P_NO_SURAT_TUGAS", noSuratTugas);
		params.put("PATH", path);
	    return new ModelAndView(view, params);
	}
//	
//	
//	
//	
//	@RequestMapping(value = "/testreport") 
//	public ModelAndView reportTest() throws SQLException{
//		JasperReportsPdfView view = new JasperReportsPdfView();
//		
//		
//		DataSource ds = new OracleDataSource();// There is other DataSource offered by Oracle , check the javadoc for more information
//	 	((OracleDataSource) ds).setDriverType("thin");
//	 	((OracleDataSource) ds).setServerName("10.254.62.38");
//	 	((OracleDataSource) ds).setPortNumber(1521);
//	 	((OracleDataSource) ds).setDatabaseName("PAJAK");
//	 	((OracleDataSource) ds).setUser("tekno");
//	 	((OracleDataSource) ds).setPassword("teknoGlobal");
//		
//		
//		view.setJdbcDataSource(ds);
//		view.setUrl("classpath:" + "report/testing.jrxml");
//		view.setApplicationContext(context);
//
//		Map<String, Object> params = new HashMap<String, Object>();
//		params.put("no_lpad", "PEM-00000078/WP.4306000000/KP.4306100000/2017");
//
//	    return new ModelAndView(view, params);
//	}
//	
//	@RequestMapping(value = "/testreport2")
//	@ResponseBody
//	public void FakturMasukanReport(HttpServletResponse response) throws JRException{
//		System.out.println("KESINi 1");
//		InputStream jasperStream = this.getClass().getResourceAsStream("/" + TESTING);
//		
//		System.out.println("KESINi 2");
//	    Map<String,Object> params = new HashMap<>();
//	    
//	    JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
//	    System.out.println("KESINi 3");
//	    
////	    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, datasource.getConnection());
//	    
//	    try {
//	    	
//	 	    
//	 	   Class.forName("oracle.jdbc.driver.OracleDriver");
//	 	  Connection connection = null;
//	 	  connection = DriverManager.getConnection("jdbc:oracle:thin:@10.254.62.38:1521:PAJAK","tekno","teknoGlobal");
//
//	 	 DataSource ds = new OracleDataSource();// There is other DataSource offered by Oracle , check the javadoc for more information
//	 	((OracleDataSource) ds).setDriverType("thin");
//	 	((OracleDataSource) ds).setServerName("10.254.62.38");
//	 	((OracleDataSource) ds).setPortNumber(1521);
//	 	((OracleDataSource) ds).setDatabaseName("PAJAK");
//	 	((OracleDataSource) ds).setUser("tekno");
//	 	((OracleDataSource) ds).setPassword("teknoGlobal");
//	 	  
//	 	    
//	 	    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, connection);
//		    System.out.println("KESINi 4");
//		    
//		    response.setContentType("application/x-pdf");
//		    response.setHeader("Content-disposition", "inline; filename="+ "iswayngereportin" +".pdf");
//		    
//		    final OutputStream outStream = response.getOutputStream();
//		    JasperExportManager.exportReportToPdfStream(jasperPrint, outStream); 
//		    
//		    connection.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	   
//
//	}
*/}
