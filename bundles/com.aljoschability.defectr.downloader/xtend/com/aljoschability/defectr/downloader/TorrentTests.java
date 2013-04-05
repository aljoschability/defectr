package com.aljoschability.defectr.downloader;

import com.turn.ttorrent.client.Client;
import com.turn.ttorrent.client.SharedTorrent;
import java.net.InetAddress;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class TorrentTests {
  public static void main(final String[] args) {
    try {
      final SharedTorrent torrent = null;
      final InetAddress address = null;
      final Client c = new Client(address, torrent);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
