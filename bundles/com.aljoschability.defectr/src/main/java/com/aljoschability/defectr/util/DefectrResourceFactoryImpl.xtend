package com.aljoschability.defectr.util;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;

public class DefectrResourceFactoryImpl extends ResourceFactoryImpl {
	override Resource createResource(URI uri) {
		val resource = new XMIResourceImpl(uri)

		resource.setEncoding("UTF-8")
		resource.getDefaultSaveOptions().put(XMLResource.OPTION_USE_ENCODED_ATTRIBUTE_STYLE, Boolean.TRUE)
		resource.getDefaultSaveOptions().put(XMLResource.OPTION_LINE_WIDTH, 0)

		return resource;
	}
}
