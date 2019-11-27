package com.example.clientmap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@EnableAutoConfiguration
public class ClientMapController {

    private static Logger log = LoggerFactory.getLogger(ClientMapController.class);

    @Autowired
    private ChannelService channelService;

    ClientMap clientMap = null;

    @RequestMapping("/hello")
    @ResponseBody
    public ResponseEntity<List<ClientMap>> hello(){

    log.info("Occurrences" + channelService.getAllChannels());


            return new ResponseEntity<List<ClientMap>>(channelService.getAllChannels(),HttpStatus.CREATED);
    }






}
