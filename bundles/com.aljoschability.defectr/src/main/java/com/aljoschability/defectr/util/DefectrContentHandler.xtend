package com.aljoschability.defectr.util

import java.io.IOException
import java.io.InputStream
import java.util.Map

import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.ContentHandler

class DefectrContentHandler implements ContentHandler {
	override boolean canHandle(URI uri) {

		// TODO Auto-generated method stub
		return false
	}

	override Map<String, ?> contentDescription(URI uri, InputStream inputStream, Map<?, ?> options,
		Map<Object, Object> context) throws IOException {

		// TODO Auto-generated method stub
		return null
	}
}
