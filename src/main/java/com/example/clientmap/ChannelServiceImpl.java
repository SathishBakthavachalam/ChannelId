package com.example.clientmap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames = "clientIdMapCache")
public class ChannelServiceImpl implements ChannelService {

    @Autowired
    private static EmployeeDAO employeeDAO;

    private static Logger log = LoggerFactory.getLogger(ChannelServiceImpl.class);

    private static List<ClientMap> clientMapList = employeeDAO.allEmployees();

    @Cacheable(unless = "#result.size() > 1000")
    @Override
    public List<ClientMap> getAllChannels() {
        log.info("Executing: " + this.getClass().getSimpleName() + ".findAll();");
        return clientMapList;
    }

    @Cacheable
    @Override
    public ClientMap findByChannelId(int index) {
        log.info("Executing: " + this.getClass().getSimpleName() + ".findByIndex(\"" + index + "\");");
        return clientMapList.get(index);
    }

    @CachePut
    @Override
    public void save(ClientMap clientMap) {
        log.info("Executing: " + this.getClass().getSimpleName() + ".save(\"" + clientMap + "\");");
        clientMapList.add(clientMap);
    }

    @CacheEvict
    @Override
    public void delete(ClientMap clientMap) {
        log.info("Executing: " + this.getClass().getSimpleName() + ".delete(\"" + clientMap + "\");");
        clientMapList.remove(clientMap);
    }

    @CacheEvict(allEntries = true)
    @Override
    public void deleteAll() {
        log.info("Executing: " + this.getClass().getSimpleName() + ".deleteAll();");
        clientMapList.removeAll(clientMapList);
    }

}
