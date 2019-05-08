package com.prosmv.constants.url;

/**
 * This class is a constant class which contains all the api end points url.
 * 
 * @author piyush
 *
 */
public final class ApiUrl {

	private ApiUrl() {

	}

	public static final String BASE_URL = "/api/v1";
	public static final String LOGIN_URL = BASE_URL + "/user/login";

	public static final String LOGOUT_URL = BASE_URL + "/user/logout";
	// Customer
	public static final String REGISTER_CUSTOMER = BASE_URL + "/register/customer";
	public static final String UPDATE_CUSTOMER = BASE_URL + "/update/customer";
	public static final String DELETE_CUSTOMER = BASE_URL + "/delete/customer";
	public static final String ACTIVATE_CUSTOMER = BASE_URL + "/activate/customer";
	public static final String DEACTIVATE_CUSTOMER = BASE_URL + "/deactivate/customer";
	public static final String ADD_BRAND = BASE_URL + "/add/brand";
	public static final String GET_ALL_BRANDS = BASE_URL + "/get/allBrands";
	public static final String DELETE_BRAND = BASE_URL + "/delete/brand";
	public static final String GET_FACTORY_CUSTOMERS = BASE_URL + "/customers/factory";
	public static final String GET_COMPANY_CUSTOMERS = BASE_URL + "/customers/company";
	public static final String GET_USER_CUSTOMERS = BASE_URL + "/customers/user";
	public static final String GET_USER_FACTORIESS = BASE_URL + "/factories/user";
	public static final String AUTO_COMPLETE_CUSTOMER = BASE_URL + "/auto/complete/customer";

	// Stitch Class
	public static final String CREATE_STITCHCLASS = BASE_URL + "/create/stitchClass";
	public static final String UPDATE_STITCHCLASS = BASE_URL + "/update/stitchClass";
	public static final String GET_ALL_STITCHCLASSES = BASE_URL + "/get/allStitchClasses";
	public static final String DELETE_STITCHCLASS = BASE_URL + "/delete/stitchClass";
	public static final String GET_USER_STITCHCLASSES = BASE_URL + "/stitchClasses/user";

	// Machine
	public static final String CREATE_MACHINE = BASE_URL + "/create/machine";
	public static final String UPDATE_MACHINE = BASE_URL + "/update/machine";
	public static final String DELETE_MACHINE = BASE_URL + "/delete/machine";
	public static final String GET_ALL_MACHINES = BASE_URL + "/get/allMachines";
	public static final String GET_USER_MACHINES = BASE_URL + "/machines/user";

	// Style
	public static final String CREATE_STYLE = BASE_URL + "/create/style";
	public static final String UPDATE_STYLE = BASE_URL + "/update/style";
	public static final String DELETE_STYLE = BASE_URL + "/delete/style";
	public static final String GET_USER_STYLES = BASE_URL + "/styles/user";
	public static final String SET_STYLE_STATUS = BASE_URL + "/set/style/status";
	public static final String GET_ALL_STYLES = BASE_URL + "/get/allStyles";
	public static final String AUTO_COMPLETE_STYLE = BASE_URL + "/auto/complete/style";
	public static final String AUTO_COMPLETE_RANGE = BASE_URL + "/auto/complete/range";
	public static final String AUTO_COMPLETE_CATEGORY = BASE_URL + "/auto/complete/category";
	public static final String AUTO_COMPLETE_GRID_SIZE = BASE_URL + "/auto/complete/gridsize";
	public static final String CREATE_SIZE_GRID = BASE_URL + "/create/sizegrid";
	public static final String CREATE_SIZE = BASE_URL + "/create/size";
	public static final String CREATE_RANGE = BASE_URL + "/create/range";
	public static final String CREATE_CATEGORY = BASE_URL + "/create/category";

	public static final String GET_RANGE_BY_FACTORY = BASE_URL + "/get/factory/range";

	public static final String GET_CATEGORY_BY_FACTORY = BASE_URL + "/get/factory/category";

	public static final String GET_SIZE_GRID_BY_FACTORY = BASE_URL + "/get/factory/gridsize";

	public static final String GET_SIZE_BY_GRID_SIZE = BASE_URL + "/get/gridsize/size";

}
