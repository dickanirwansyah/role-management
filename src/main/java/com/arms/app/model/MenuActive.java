/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arms.app.model;

import java.util.List;

import com.arms.app.entity.Menu;

/**
 *
 * @author albab
 */
@SuppressWarnings("serial")
public class MenuActive extends Menu{
   private List<Menu> sub;

   public MenuActive(){
       super();
   }
   
   public MenuActive(Menu menu){
       super();
       this.setActive(menu.getActive());
       this.setId(menu.getId());
       this.setLevelMenu(menu.getLevelMenu());
       this.setMenuName(menu.getMenuName());
       this.setParentId(menu.getParentId());
       this.setPathName(menu.getPathName());
       this.setClassStyle(menu.getClassStyle());
       this.setMenuType(menu.getMenuType());
   }
    /**
     * @return the sub
     */
    public List<Menu> getSub() {
        return sub;
    }

    /**
     * @param sub the sub to set
     */
    public void setSub(List<Menu> sub) {
        this.sub = sub;
    }
   
}
