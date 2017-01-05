package com.pivotal.nab.api.fx.demo.controller;

import com.pivotal.nab.api.fx.demo.Utils;
import com.pivotal.nab.api.fx.demo.beans.FxRate;
import com.pivotal.nab.api.fx.demo.beans.NabApiKey;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Arrays;
import java.util.List;

@Controller
public class FxController
{
    private static Log logger = LogFactory.getLog(FxController.class);

    @Autowired
    NabApiKey nabApiKey;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String fxPage(Model model) throws Exception
    {
        logger.info("Invoking FxController");
        logger.info(nabApiKey.toString());

        List<FxRate> rates = Utils.getFx(nabApiKey.getNabApiKey());
        model.addAttribute("rates", rates);

        logger.info(Arrays.toString(rates.toArray()));

        return "fxapi";
    }
}
