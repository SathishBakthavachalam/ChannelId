package com.example.clientmap;

import java.util.List;

public interface ChannelService {

    List<ClientMap> getAllChannels();

    ClientMap findByChannelId(int index);

    void save(ClientMap instrument);

    void delete(ClientMap instrument);

    void deleteAll();

}
