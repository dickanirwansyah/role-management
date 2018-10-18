package com.arms.app.test;
/*package com.djp.app.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.djp.app.service.BerkasPermohonanService;
import com.djp.app.service.DataLDAPService;
import com.djp.app.service.InputDataService;
import com.djp.app.service.MonitoringService;
import com.djp.app.service.PenugasanPelaksanaPelayananService;
import com.djp.app.service.SKKeberatanService;
import com.djp.app.service.SuratPemberitahuanHadirService;
import com.djp.app.service.SuratPengantarService;
import com.djp.app.util.ConstantaVariable.BerkasPermohonanKeberatanPrefix;
import com.djp.app.util.JacksonUtil;

import id.go.pajak.adm.keberatan.model.Dokumen;
import id.go.pajak.adm.keberatan.model.KelengkapanBerkas;
import id.go.pajak.adm.keberatan.model.LampiranDokumen;
import id.go.pajak.adm.keberatan.model.MasterPegawai;
import id.go.pajak.adm.keberatan.model.MonitoringBpm;
import id.go.pajak.adm.keberatan.model.PengajuanKeberatan;
import id.go.pajak.adm.keberatan.model.Pengantar;
import id.go.pajak.adm.keberatan.model.PengantarKeberatan;
import id.go.pajak.adm.keberatan.model.PengawasanPenelitian;
import id.go.pajak.adm.keberatan.model.SuratHadir;

public class Test {

//	public static void main(String[] args) {
		public static void main() {
		// TODO Auto-generated method stub
		InputDataService inputDataService = new InputDataService();
//		List result = inputDataService.getNpwp("33333");
//		List result = inputDataService.getPermohonanDtl("1115");
//		List result = inputDataService.getDokumen("1115");
//		Object result = inputDataService.getPermohonanDtl("1115");
		insert();
		
		PenugasanPelaksanaPelayananService penugasanPPService = new PenugasanPelaksanaPelayananService();
//		List result = penugasanPPService.getTaskList();
//		Object result = penugasanPPService.getPermohonanDtl("1115");
//		List result = penugasanPPService.getDokumen("1115");
//		String result = penugasanPPService.updatePermohonan("1115", "adit ucul beud");
//		updatePelaksanaPelayanan();

		
		BerkasPermohonanService berkasPermohonan = new BerkasPermohonanService();
//		List result = berkasPermohonan.getTaskList();
//		Object result = berkasPermohonan.getPermohonanDtl("1115");
//		List result = berkasPermohonan.getKelengkapanBerkas("1115");
//		List result = berkasPermohonan.getPengawasanPenelitian("1115");
//		inserBerkasPermohonan();
//		updateBerkasPermohonan();
		
		
		SuratPengantarService suratPengantarService = new SuratPengantarService();
//		List result = suratPengantarService.getTaskList();
//		Object result = suratPengantarService.getSuratPengantarPopup("001");
//		List result = suratPengantarService.getSuratPengantarPopupList("001");
//		List result = suratPengantarService.getSearchNoBPS("");
//		insertSuratengantar();
//		updateSuratengantar();
		

		SuratPemberitahuanHadirService hadirService = new SuratPemberitahuanHadirService();
//		List result = hadirService.getTaskList();
//		Object result = hadirService.getPermohonanDtl("1115");
//		List result = hadirService.getPemberitahuanHadirDokumen("5");	
//		Object result = hadirService.getPemberitahuanHadirSPUH("5");
//		insertSuratHadir();
		
		
		SKKeberatanService keberatanService = new SKKeberatanService(); 
//		List result = keberatanService.getTaskList();
//		Object result = keberatanService.getPermohonanDtl("5");
//		List result = keberatanService.getSKKeberatanPopupDtl("5");
		
		
//		insertBPMMonitoring();
//		insertLDAP();
//		System.out.println("Result : " + result);
		
		
//		testList();
	}
	
	
	public static void insertLDAP(){
		DataLDAPService ldapService = new DataLDAPService();
		List<MasterPegawai> listPeg = new ArrayList<>();
//		MasterPegawai peg = new MasterPegawai();
//		peg.setNip("11");
//		peg.setNama_pegawai("adit");
//		listPeg.add(peg);
//		peg = new MasterPegawai();
//		peg.setNip("12");
//		peg.setNama_pegawai("bayu");
//		listPeg.add(peg);
		int max = 1000;
		for(int i=0; i<max; i++){
			MasterPegawai peg = new MasterPegawai();
			peg.setNip(String.valueOf(i));
			peg.setNama_pegawai("test");
			listPeg.add(peg);
		}
		ldapService.insertUserLDAP(listPeg);
	}
	
	public static void insertBPMMonitoring(){
		MonitoringService service = new MonitoringService();
		MonitoringBpm monitoring = new MonitoringBpm();
		monitoring.setInstance_id("111");
		monitoring.setNo_lpad("111");
		
		String result = service.insertMonitoring(monitoring);
		System.out.println("RESULT : " + result);
	}
	
	public static void insert(){
		InputDataService inputDataService = new InputDataService();
		
		PengajuanKeberatan pengajuanKeberatan = new PengajuanKeberatan();
		pengajuanKeberatan.setNo_lpad("1118");
		pengajuanKeberatan.setNo_keberatan("11118");
		pengajuanKeberatan.setNama_wp("isbeh BL");
		pengajuanKeberatan.setTanggal_terima(null);
		String res =  inputDataService.insertPengajuan(pengajuanKeberatan, "007", "123", "tekno");
		
		Map<String, Object> data = JacksonUtil.jsonStringToMap(res);
		System.out.println("data : " + data);
		System.out.println("data get : " + data.get("no_lpad"));
		
//		List<LampiranDokumen> lstDokumen = new ArrayList<>();
//		LampiranDokumen dokumen = new LampiranDokumen();
//		dokumen.setNo_lpad("1116");
//		dokumen.setNo_dokumen("111");
//		dokumen.setNama_dokumen("Dokumen 1");
//		lstDokumen.add(dokumen);
//		
//		dokumen = new LampiranDokumen();
//		dokumen.setNo_lpad("1116");
//		dokumen.setNo_dokumen("222");
//		dokumen.setNama_dokumen("Dokumen 2");
//		lstDokumen.add(dokumen);
//		
//		dokumen = new LampiranDokumen();
//		dokumen.setNo_lpad("1116");
//		dokumen.setNo_dokumen("333");
//		dokumen.setNama_dokumen("Dokumen 3");
//		lstDokumen.add(dokumen);
//		
////		String res =  inputDataService.insertDokumen(lstDokumen);
//		
//		
//		
//		DataSkpBukpot skpbukpot = new DataSkpBukpot();
//		skpbukpot.setFlag_skp_bukpot(new BigDecimal(1));
//		skpbukpot.setNo_skp_bukti_potong("123321123");
//		skpbukpot.setNpwp("33333");
//		skpbukpot.setNama_wp("isway");
//		skpbukpot.setAlamat_wp("bayoran");
//		String res =  inputDataService.insertBuktiPotong(skpbukpot);
//		
		System.out.println("RES : " + res);
	}
		
	public static void update(){
		InputDataService inputDataService = new InputDataService();
		PengajuanKeberatan pengajuanKeberatan =  new PengajuanKeberatan();

		pengajuanKeberatan.setNo_lpad("1116");
		pengajuanKeberatan.setNo_keberatan("11116");
		pengajuanKeberatan.setNama_wp("isway BL");
//		String res =  inputDataService.updatePermohonan(pengajuanKeberatan); 
		
		List<LampiranDokumen> lstDokumen = new ArrayList<>();
		LampiranDokumen dokumen = new LampiranDokumen();
		dokumen.setLampiran_dokumen_id(new BigDecimal(123));
		dokumen.setNo_lpad("1116");
		dokumen.setNo_dokumen("222");
		dokumen.setNama_dokumen("Dokumen aja");
		lstDokumen.add(dokumen);
//		String res = inputDataService.updateDokumen(lstDokumen);
		
		String res = inputDataService.updateCetak("1115");
		
//		System.out.println("Result : " + res);
	}
	
	public static void updatePelaksanaPelayanan(){

		PenugasanPelaksanaPelayananService PP = new PenugasanPelaksanaPelayananService();
		
		String res = PP.updatePermohonan("1115", "adit bacut");
		System.out.println("Result : " + res);
	}

	public static void inserBerkasPermohonan(){
		BerkasPermohonanService berkasPermohonan = new BerkasPermohonanService();
		
		List<KelengkapanBerkas> listKelengkapanBerkas = new ArrayList<>();
		KelengkapanBerkas kelengkapanBerkas = new KelengkapanBerkas();
		kelengkapanBerkas.setNo_lpad("1115");
		kelengkapanBerkas.setJenis_kelengkapan_id(new BigDecimal(3));
		kelengkapanBerkas.setStatus_kelengkapan("cancel");
		listKelengkapanBerkas.add(kelengkapanBerkas);
		
		kelengkapanBerkas = new KelengkapanBerkas();
		kelengkapanBerkas.setNo_lpad("1115");
		kelengkapanBerkas.setJenis_kelengkapan_id(new BigDecimal(5));
		kelengkapanBerkas.setStatus_kelengkapan("cancel");
		listKelengkapanBerkas.add(kelengkapanBerkas);
		
//		String result = berkasPermohonan.insertKelengkapanBerkas(listKelengkapanBerkas);
		
		
		List<PengawasanPenelitian> listPengawasanPeneitian = new ArrayList<>();
		PengawasanPenelitian pengawasanPenelitian = new PengawasanPenelitian();
		pengawasanPenelitian.setNo_lpad("1115");
		pengawasanPenelitian.setJenis_penelitian_id(new BigDecimal(3));
		pengawasanPenelitian.setNama_pelaksana("bayu");
		listPengawasanPeneitian.add(pengawasanPenelitian);
		
		pengawasanPenelitian = new PengawasanPenelitian();
		pengawasanPenelitian.setNo_lpad("1115");
		pengawasanPenelitian.setJenis_penelitian_id(new BigDecimal(5));
		pengawasanPenelitian.setNama_pelaksana("isway");
		listPengawasanPeneitian.add(pengawasanPenelitian);
		
		
//		String result = berkasPermohonan.insertPengawasanPenelitian(listPengawasanPeneitian);
//		System.out.println("RESULt : " + result); 
	}
	
	public static void updateBerkasPermohonan(){
		BerkasPermohonanService berkasPermohonan = new BerkasPermohonanService();
		
		List<KelengkapanBerkas> listKelengkapanBerkas = new ArrayList<>();
		KelengkapanBerkas kelengkapanBerkas = new KelengkapanBerkas();
		kelengkapanBerkas.setKelengkapan_berkas_id(new BigDecimal(3));
		kelengkapanBerkas.setNo_lpad("1115");
		kelengkapanBerkas.setJenis_kelengkapan_id(new BigDecimal(1));
		kelengkapanBerkas.setStatus_kelengkapan("lengkap");
		listKelengkapanBerkas.add(kelengkapanBerkas);
		
		kelengkapanBerkas = new KelengkapanBerkas();
		kelengkapanBerkas.setKelengkapan_berkas_id(new BigDecimal(4));
		kelengkapanBerkas.setNo_lpad("1115");
		kelengkapanBerkas.setJenis_kelengkapan_id(new BigDecimal(3));
		kelengkapanBerkas.setStatus_kelengkapan("lengkap");	
		listKelengkapanBerkas.add(kelengkapanBerkas);
//		String result = berkasPermohonan.updateKelengkapanBerkas(listKelengkapanBerkas);
		
		List<PengawasanPenelitian> listPengawasanPenelitian = new ArrayList<>();
		PengawasanPenelitian pengawasanPenelitian = new PengawasanPenelitian();
		pengawasanPenelitian.setPengawasan_penelitian_id(new BigDecimal(1));
		pengawasanPenelitian.setNo_lpad("1115");
		pengawasanPenelitian.setJenis_penelitian_id(new BigDecimal(1));
		pengawasanPenelitian.setNama_pelaksana("way");
		
		listPengawasanPenelitian.add(pengawasanPenelitian);
		pengawasanPenelitian = new PengawasanPenelitian();
		pengawasanPenelitian.setPengawasan_penelitian_id(new BigDecimal(3));
		pengawasanPenelitian.setNo_lpad("1115");
		pengawasanPenelitian.setJenis_penelitian_id(new BigDecimal(3));
		pengawasanPenelitian.setNama_pelaksana("adit kiting");
		listPengawasanPenelitian.add(pengawasanPenelitian);
		
//		String result = berkasPermohonan.updatePengawasanPenelitian(listPengawasanPenelitian);
		
//		System.out.println("RESULt : " + result); 
	}

	public static void insertSuratengantar(){
		SuratPengantarService suratPengantarService = new SuratPengantarService();
		
		Pengantar pengantar = new Pengantar();
		pengantar.setNo_surat_pengantar("002");
		pengantar.setNo_resi("987654321");
//		String result = suratPengantarService.insertSuratPengantarPopup(pengantar);
		
		List<PengantarKeberatan> listPengantarkeberatan = new ArrayList<>();
		PengantarKeberatan pengantarKeberatan = new PengantarKeberatan();
		pengantarKeberatan.setNo_surat_pengantar("002");
		pengantarKeberatan.setNo_lpad("12");
		listPengantarkeberatan.add(pengantarKeberatan);
		
		pengantarKeberatan = new PengantarKeberatan();
		pengantarKeberatan.setNo_surat_pengantar("002");
		pengantarKeberatan.setNo_lpad("14");
		listPengantarkeberatan.add(pengantarKeberatan);
		
		pengantarKeberatan = new PengantarKeberatan();
		pengantarKeberatan.setNo_surat_pengantar("002");
		pengantarKeberatan.setNo_lpad("15");
		listPengantarkeberatan.add(pengantarKeberatan);
		
		String result = "";//suratPengantarService.insertSuratPengantarPopupList(listPengantarkeberatan);
		
		System.out.println("Result : " + result);
	}
	
	public static void updateSuratengantar(){
		SuratPengantarService suratPengantarService = new SuratPengantarService();
		
		Pengantar pengantar = new Pengantar();
		pengantar.setNo_surat_pengantar("002");
		pengantar.setNo_resi("5432109876");
//		String result = suratPengantarService.updatetSuratPengantarPopup(pengantar);
		
		List<PengantarKeberatan> listPengantarkeberatan = new ArrayList<>();
		PengantarKeberatan pengantarKeberatan = new PengantarKeberatan();
		pengantarKeberatan.setPengantar_keberatan_id(new BigDecimal(25));
		pengantarKeberatan.setNo_surat_pengantar("002");
		pengantarKeberatan.setNo_lpad("11");
		pengantarKeberatan.setStatus_aktif(new BigDecimal(0));
		listPengantarkeberatan.add(pengantarKeberatan);
		
		pengantarKeberatan = new PengantarKeberatan();
		pengantarKeberatan.setPengantar_keberatan_id(new BigDecimal(27));
		pengantarKeberatan.setNo_surat_pengantar("002");
		pengantarKeberatan.setNo_lpad("13");
		pengantarKeberatan.setStatus_aktif(new BigDecimal(0));
		listPengantarkeberatan.add(pengantarKeberatan);
		
		String result = "";//suratPengantarService.updatetSuratPengantarPopupList(listPengantarkeberatan);
		
		System.out.println("Result : " + result);
	}

	public static void insertSuratHadir(){
		SuratPemberitahuanHadirService hadirService = new SuratPemberitahuanHadirService();
		List<Dokumen> listDokumen = new ArrayList<>();
		Dokumen dokumen = new Dokumen();
		dokumen.setNo_lpad("5");
		dokumen.setNomor_dokumen("D00003");
		dokumen.setJenis_dokumen_id(new BigDecimal(1));
		dokumen.setNama_dokumen("akta lahir");
		listDokumen.add(dokumen);
		
		dokumen = new Dokumen();
		dokumen.setNo_lpad("5");
		dokumen.setNomor_dokumen("D00004");
		dokumen.setJenis_dokumen_id(new BigDecimal(2));
		dokumen.setNama_dokumen("surat cerai");
		listDokumen.add(dokumen);
		
//		String result = hadirService.insertPemberitahuanHadirDokumen(listDokumen);
		
		SuratHadir suratHadir = new SuratHadir();		
		suratHadir.setSyarat_formal_id(new BigDecimal(21));
		suratHadir.setNo_surat_hadir("0001hadir");
		suratHadir.setJumlah_lampiran(new BigDecimal(3));
		suratHadir.setWaktu_undang("siang");
		suratHadir.setTempat_undang("mall");
		suratHadir.setMenemui("adit ucul");
//		String result = hadirService.insertPemberitahuanHadirSPUH(suratHadir); 
		
//		System.out.println("RESULT : " + result);
	}

	public static void updateSuratHadir(){
		SuratPemberitahuanHadirService suratHadirService = new SuratPemberitahuanHadirService();
		
	}

	
	public static void testList(){
		List<KelengkapanBerkas> listAwal = new ArrayList<>();
		KelengkapanBerkas awal = new KelengkapanBerkas();
//		awal.setJenis_kelengkapan_id(new BigDecimal(11));
//		awal.setStatus_aktif(new BigDecimal(0));
//		awal.setKeterangan_status("lengkap");
//		listAwal.add(awal);
		
//		awal = new KelengkapanBerkas();
//		awal.setJenis_kelengkapan_id(new BigDecimal(12));
//		awal.setStatus_aktif(new BigDecimal(0));
//		awal.setKeterangan_status("cukup");
//		listAwal.add(awal);
		
		awal = new KelengkapanBerkas();
		awal.setKelengkapan_berkas_id(new BigDecimal(1));
		awal.setJenis_kelengkapan_id(new BigDecimal(13));
		awal.setStatus_aktif(new BigDecimal(0));
		awal.setKeterangan_status("mantap");
		listAwal.add(awal);
		
		awal = new KelengkapanBerkas();
		awal.setKelengkapan_berkas_id(new BigDecimal(5));
		awal.setJenis_kelengkapan_id(new BigDecimal(13));
		awal.setStatus_aktif(new BigDecimal(0));
		awal.setKeterangan_status("mantap");
		listAwal.add(awal);
		
		
		List<KelengkapanBerkas> listNew = new ArrayList<>();
		KelengkapanBerkas baru = new KelengkapanBerkas();
		baru.setJenis_kelengkapan_id(new BigDecimal(11));
		baru.setStatus_aktif(new BigDecimal(0));
		baru.setKeterangan_status("lengkap");
		listNew.add(baru);
		
		baru = new KelengkapanBerkas();
		baru.setJenis_kelengkapan_id(new BigDecimal(12));
		baru.setStatus_aktif(new BigDecimal(0));
		baru.setKeterangan_status("cukup");
		listNew.add(baru);
		
		baru = new KelengkapanBerkas();
		baru.setKelengkapan_berkas_id(new BigDecimal(1));
		baru.setJenis_kelengkapan_id(new BigDecimal(13));
		baru.setStatus_aktif(new BigDecimal(0));
		baru.setKeterangan_status("mantap");
		listNew.add(baru);
		
		
		
		
		List listAdd = new ArrayList<>();
		List listUpdateDelete = new ArrayList<>();
		
		System.out.println("START");
		for(KelengkapanBerkas dataNew : listNew){
			if(dataNew.getKelengkapan_berkas_id() == null){
				listAdd.add(dataNew);
			}else{
				listUpdateDelete.add(dataNew);
			}
		}
		
		for(KelengkapanBerkas dataAwal : listAwal){
			BigDecimal idAwal = dataAwal.getKelengkapan_berkas_id();
			if(idAwal != null){
				boolean delete = true;
				for(KelengkapanBerkas dataNew : listNew){
					BigDecimal idNew = dataNew.getKelengkapan_berkas_id();
					if(idNew != null){
						if(idAwal.compareTo(idNew) == 0){
							delete = false;
							break;
						}
					}
				}
				
				if(delete){
					dataAwal.setStatus_aktif(new BigDecimal(1));
					listUpdateDelete.add(dataAwal);
				}
			}
		}
		
		
		System.out.println("LIST ADD : " + listAdd);
		System.out.println("LIST UPDATE : " + listUpdateDelete);
	}
}
*/