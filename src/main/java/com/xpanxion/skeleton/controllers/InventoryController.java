package com.xpanxion.skeleton.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xpanxion.skeleton.service.LotService;

@Controller
public class InventoryController {

    public static final String INVENTORY_PAGE = "common.inventory";
    public static final String INVENTORY_URL = "inventory";
    private static final String LOT = "lot";

    @Autowired
    private LotService lotService;

    @RequestMapping(value = "/" + INVENTORY_URL, method = RequestMethod.GET)
    public ModelAndView getInventory() {
        ModelAndView mAndv = new ModelAndView(INVENTORY_PAGE);
        mAndv.addObject(LOT, this.lotService.getLot().getCars());
        return mAndv;
    }
}
