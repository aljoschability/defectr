package com.aljoschability.defectr.downloader

import com.turn.ttorrent.client.Client
import java.net.InetAddress
import com.turn.ttorrent.client.SharedTorrent

class TorrentTests {
	def static void main(String[] args) {
		val SharedTorrent torrent = null
		val InetAddress address = null
		val c = new Client(address, torrent)

		println(c)
	}
}
