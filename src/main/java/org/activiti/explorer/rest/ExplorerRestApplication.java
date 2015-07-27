package org.activiti.explorer.rest;
//public class ExplorerRestApplication extends ActivitiRestApplication {
//
//	public ExplorerRestApplication() {
//		super();
//	}
//
//	/**
//	 * Creates a root Restlet that will receive all incoming calls.
//	 */
//	@Override
//	public synchronized Restlet createInboundRoot() {
//		org.restlet.Context context = getContext();
//		Router router = new Router(context);
//		router.attachDefault(DefaultResource.class);
//		ModelerServicesInit.attachResources(router);
//		DiagramServicesInit.attachResources(router);
//		JsonpFilter jsonpFilter = new JsonpFilter(context);
//		jsonpFilter.setNext(router);
//		return jsonpFilter;
//	}
//
//}
