package unicamp.buscame;

import android.app.Application;

import unicamp.buscame.util.ActivityController;
import unicamp.buscame.util.ActivityControllerFactory;

public class App extends Application implements IInterfaceTags {
	private ActivityController activityController;
	public App() {
		super();
	}

	@Override
	public void onCreate() {
		super.onCreate();
		start();
		activityController= ActivityControllerFactory.createInstance();

	}

	@Override
	public void onTerminate() {
		super.onTerminate();
	}

	//requirements
	private mapekcosmos.components.prov.IManager comp;
	private mapekcosmos.components.prov.IComponentManager compIComp;
	private mapekcosmos.sensors.prov.IManager sens;
	private mapekcosmos.sensors.prov.ISensorManager sensISens;
	private mapekcosmos.connectors.prov.IManager conn;
	private mapekcosmos.connectors.prov.IConnectorManager connIConn;
	private mapekcosmos.features.prov.IManager feature;
	private mapekcosmos.features.prov.IFeatureManager featureIFeature;
	private mapekcosmos.variability.prov.IManager varia;
	private mapekcosmos.variability.prov.IVariabilityManager variaIVaria;
	private mapekcosmos.reader.prov.IManager reade;
	private mapekcosmos.reader.prov.IReadingManager readeIReading;
	private mapekcosmos.analyzer.prov.IManager analy;
	private mapekcosmos.analyzer.prov.IAnalysisManager analyIAnaly;
	private mapekcosmos.planner.prov.IManager plann;
	private mapekcosmos.planner.prov.IPlanningManager plannIPlann;
	private mapekcosmos.executer.prov.IManager execu;
	private mapekcosmos.executer.prov.IExecutionManager execuIExecu;
	private mapekcosmos.controller.prov.IManager controll;
	private mapekcosmos.controller.prov.IControllerManager controllIControll;
	//mapekcosmos.connectors
	private mapekcosmos.conn_analyzer_controller.prov.IManager analy_controll;
	private mapekcosmos.conn_analyzer_planner.prov.IManager analy_plann;
	private mapekcosmos.conn_components_connectors.prov.IManager comp_conn;
	private mapekcosmos.conn_components_planner.prov.IManager comp_plann;
	private mapekcosmos.conn_components_reader.prov.IManager comp_reade;
	private mapekcosmos.conn_components_variability.prov.IManager comp_varia;
	private mapekcosmos.conn_connectors_planner.prov.IManager conn_plann;
	private mapekcosmos.conn_connectors_reader.prov.IManager conn_reade;
	private mapekcosmos.conn_connectors_variability.prov.IManager conn_varia;
	private mapekcosmos.conn_controller_main.prov.IManager controll_mainM;
	private mapekcosmos.conn_executer_controller.prov.IManager execu_controll;
	private mapekcosmos.conn_features_reader.prov.IManager feature_reade;
	private mapekcosmos.conn_features_variability.prov.IManager feature_varia;
	private mapekcosmos.conn_planner_controller.prov.IManager plann_controll;
	private mapekcosmos.conn_planner_executer.prov.IManager plann_execu;
	private mapekcosmos.conn_reader_main.prov.IManager reade_mainM;
	private mapekcosmos.conn_sensors_analyzer.prov.IManager sens_analy;
	private mapekcosmos.conn_sensors_connectors.prov.IManager sens_conn;
	private mapekcosmos.conn_sensors_planner.prov.IManager sens_plann;
	private mapekcosmos.conn_sensors_reader.prov.IManager sens_reade;
	private mapekcosmos.conn_sensors_variability.prov.IManager sens_varia;
	private mapekcosmos.conn_variability_planner.prov.IManager varia_plann;
	private mapekcosmos.conn_variability_reader.prov.IManager varia_reade;

	//to the application
	private unicamp.buscame.product.prov.IManager product;
	private unicamp.buscame.product.prov.IProductManager productIProd;
	private unicamp.buscame.configuration.prov.IManager configuration;
	private unicamp.buscame.configuration.prov.IConfigurationManager configurationIConf;
	private unicamp.buscame.localization.prov.IManager localization;
	private unicamp.buscame.localization.prov.ILocalizationManager localizationILoca;
	private unicamp.buscame.client.prov.IManager client;
	private unicamp.buscame.client.prov.IClientManager clientIClient;
	private unicamp.buscame.company.prov.IManager company;
	private unicamp.buscame.company.prov.ICompanyManager companyIComp;
	private unicamp.buscame.ui.prov.IManager ui;
	private unicamp.buscame.ui.prov.IUiManager uiIUi;
	private unicamp.buscame.controller.prov.IManager controller;
	private unicamp.buscame.controller.prov.IControllerManager controllerIContr;
	//To the fault tolerance
	private unicamp.buscame.productB.prov.IManager productB;
	private unicamp.buscame.productB.prov.IProductManager productBIProd;
	private unicamp.buscame.productC.prov.IManager productC;
	private unicamp.buscame.productC.prov.IProductManager productCIProd;
	private unicamp.buscame.localizationB.prov.IManager localizationB;
	private unicamp.buscame.localizationB.prov.ILocalizationManager localizationBILoca;
	private unicamp.buscame.localizationC.prov.IManager localizationC;
	private unicamp.buscame.localizationC.prov.ILocalizationManager localizationCILoca;
	private unicamp.buscame.configurationB.prov.IManager configurationB;
	private unicamp.buscame.configurationB.prov.IConfigurationManager configurationBIConf;



	//
	private unicamp.buscame.conn_client_controller.prov.IManager client_controller;
	private unicamp.buscame.conn_client_ui.prov.IManager client_ui;
	private unicamp.buscame.conn_company_controller.prov.IManager company_controller;
	private unicamp.buscame.conn_company_ui.prov.IManager company_ui;
	private unicamp.buscame.conn_configuration_company.prov.IManager configuration_company;
	private unicamp.buscame.conn_product_company.prov.IManager product_company;
	private unicamp.buscame.conn_localization_company.prov.IManager localization_company;
	private unicamp.buscame.conn_ui_controller.prov.IManager ui_controller;
	//To the fault Tolerance

	private unicamp.buscame.conn_productB_company.prov.IManager productB_company;
	private unicamp.buscame.conn_productC_company.prov.IManager productC_company;
	private unicamp.buscame.conn_localizationB_company.prov.IManager localizationB_company;
	private unicamp.buscame.conn_localizationC_company.prov.IManager localizationC_company;
	private unicamp.buscame.conn_configurationB_company.prov.IManager configurationB_company;


	private void start() {
		// To the mapekcosmos
		comp = mapekcosmos.components.impl.ComponentFactory.createInstance();
		compIComp =
				(mapekcosmos.components.prov.IComponentManager) comp.getProvidedInterface(IComponentManagerTag);
		sens = mapekcosmos.sensors.impl.ComponentFactory.createInstance();
		sensISens = (mapekcosmos.sensors.prov.ISensorManager) sens.getProvidedInterface(ISensorManagerTag);

		conn = mapekcosmos.connectors.impl.ComponentFactory.createInstance();
		//mapekcosmos.connectors to conn
		comp_conn = mapekcosmos.conn_components_connectors.impl.ComponentFactory.createInstance();
		comp_conn.setRequiredInterface(IComponentManagerTag, compIComp);
		sens_conn = mapekcosmos.conn_sensors_connectors.impl.ComponentFactory.createInstance();
		sens_conn.setRequiredInterface(ISensorManagerTag, sensISens);
		//sets
		conn.setRequiredInterface(IComponentManagerTag,
				comp_conn.getProvidedInterface(IComponentManagerTag));
		conn.setRequiredInterface(ISensorManagerTag,
				sens_conn.getProvidedInterface(ISensorManagerTag));
		connIConn =
				(mapekcosmos.connectors.prov.IConnectorManager) conn.getProvidedInterface(IConnectorManagerTag);

		feature = mapekcosmos.features.impl.ComponentFactory.createInstance();
		featureIFeature =
				(mapekcosmos.features.prov.IFeatureManager) feature.getProvidedInterface(IFeatureManagerTag);

		varia = mapekcosmos.variability.impl.ComponentFactory.createInstance();
		//mapekcosmos.connectors to varia
		comp_varia = mapekcosmos.conn_components_variability.impl.ComponentFactory.createInstance();
		comp_varia.setRequiredInterface(IComponentManagerTag, compIComp);
		sens_varia = mapekcosmos.conn_sensors_variability.impl.ComponentFactory.createInstance();
		sens_varia.setRequiredInterface(ISensorManagerTag, sensISens);
		feature_varia = mapekcosmos.conn_features_variability.impl.ComponentFactory.createInstance();
		feature_varia.setRequiredInterface(IFeatureManagerTag, featureIFeature);
		conn_varia = mapekcosmos.conn_connectors_variability.impl.ComponentFactory.createInstance();
		conn_varia.setRequiredInterface(IConnectorManagerTag, connIConn);
		//sets
		varia.setRequiredInterface(IComponentManagerTag,
				comp_varia.getProvidedInterface(IComponentManagerTag));
		varia.setRequiredInterface(ISensorManagerTag,
				sens_varia.getProvidedInterface(ISensorManagerTag));
		varia.setRequiredInterface(IFeatureManagerTag,
				feature_varia.getProvidedInterface(IFeatureManagerTag));
		varia.setRequiredInterface(IConnectorManagerTag,
				conn_varia.getProvidedInterface(IConnectorManagerTag));
		variaIVaria = (mapekcosmos.variability.prov.IVariabilityManager) varia
				.getProvidedInterface(IVariabilityManagerTag);

		reade = mapekcosmos.reader.impl.ComponentFactory.createInstance();
		//mapekcosmos.connectors to reade
		comp_reade = mapekcosmos.conn_components_reader.impl.ComponentFactory.createInstance();
		comp_reade.setRequiredInterface(IComponentManagerTag, compIComp);
		sens_reade = mapekcosmos.conn_sensors_reader.impl.ComponentFactory.createInstance();
		sens_reade.setRequiredInterface(ISensorManagerTag, sensISens);
		conn_reade = mapekcosmos.conn_connectors_reader.impl.ComponentFactory.createInstance();
		conn_reade.setRequiredInterface(IConnectorManagerTag, connIConn);
		feature_reade = mapekcosmos.conn_features_reader.impl.ComponentFactory.createInstance();
		feature_reade.setRequiredInterface(IFeatureManagerTag, featureIFeature);
		varia_reade = mapekcosmos.conn_variability_reader.impl.ComponentFactory.createInstance();
		varia_reade.setRequiredInterface(IVariabilityManagerTag, variaIVaria);
		//sets
		reade.setRequiredInterface(IComponentManagerTag,
				comp_reade.getProvidedInterface(IComponentManagerTag));
		reade.setRequiredInterface(ISensorManagerTag,
				sens_reade.getProvidedInterface(ISensorManagerTag));
		reade.setRequiredInterface(IConnectorManagerTag,
				conn_reade.getProvidedInterface(IConnectorManagerTag));
		reade.setRequiredInterface(IFeatureManagerTag,//
				feature_reade.getProvidedInterface(IFeatureManagerTag));
		reade.setRequiredInterface(IVariabilityManagerTag,
				varia_reade.getProvidedInterface(IVariabilityManagerTag));
		readeIReading =
				(mapekcosmos.reader.prov.IReadingManager) reade.getProvidedInterface(IReadingManagerTag);

		analy = mapekcosmos.analyzer.impl.ComponentFactory.createInstance();
		//mapekcosmos.connectors to analy
		sens_analy = mapekcosmos.conn_sensors_analyzer.impl.ComponentFactory.createInstance();
		sens_analy.setRequiredInterface(ISensorManagerTag, sensISens);
		//sets
		analy.setRequiredInterface(ISensorManagerTag,
				sens_analy.getProvidedInterface(ISensorManagerTag));
		analyIAnaly =
				(mapekcosmos.analyzer.prov.IAnalysisManager) analy.getProvidedInterface(IAnalysisManagerTag);

		plann = mapekcosmos.planner.impl.ComponentFactory.createInstance();
		//mapekcosmos.connectors to plan
		comp_plann = mapekcosmos.conn_components_planner.impl.ComponentFactory.createInstance();
		comp_plann.setRequiredInterface(IComponentManagerTag, compIComp);
		sens_plann = mapekcosmos.conn_sensors_planner.impl.ComponentFactory.createInstance();
		sens_plann.setRequiredInterface(ISensorManagerTag, sensISens);
		conn_plann = mapekcosmos.conn_connectors_planner.impl.ComponentFactory.createInstance();
		conn_plann.setRequiredInterface(IConnectorManagerTag, connIConn);
		varia_plann = mapekcosmos.conn_variability_planner.impl.ComponentFactory.createInstance();
		varia_plann.setRequiredInterface(IVariabilityManagerTag, variaIVaria);
		analy_plann = mapekcosmos.conn_analyzer_planner.impl.ComponentFactory.createInstance();
		analy_plann.setRequiredInterface(IAnalysisManagerTag, analyIAnaly);
		//sets
		plann.setRequiredInterface(IComponentManagerTag,
				comp_plann.getProvidedInterface(IComponentManagerTag));
		plann.setRequiredInterface(ISensorManagerTag,
				sens_plann.getProvidedInterface(ISensorManagerTag));
		plann.setRequiredInterface(IConnectorManagerTag,
				conn_plann.getProvidedInterface(IConnectorManagerTag));
		plann.setRequiredInterface(IVariabilityManagerTag,
				varia_plann.getProvidedInterface(IVariabilityManagerTag));
		plann.setRequiredInterface(IAnalysisManagerTag,
				analy_plann.getProvidedInterface(IAnalysisManagerTag));
		plannIPlann =
				(mapekcosmos.planner.prov.IPlanningManager) plann.getProvidedInterface(IPlanningManagerTag);

		execu = mapekcosmos.executer.impl.ComponentFactory.createInstance();
		//mapekcosmos.connectors to execu
		plann_execu = mapekcosmos.conn_planner_executer.impl.ComponentFactory.createInstance();
		plann_execu.setRequiredInterface(IPlanningManagerTag, plannIPlann);
		//seters to execu
		execu.setRequiredInterface(IPlanningManagerTag,
				plann_execu.getProvidedInterface(IPlanningManagerTag));
		execuIExecu =
				(mapekcosmos.executer.prov.IExecutionManager) execu.getProvidedInterface(IExecutionManagerTag);

		controll = mapekcosmos.controller.impl.ComponentFactory.createInstance();
		//mapekcosmos.connectors to controll
		analy_controll = mapekcosmos.conn_analyzer_controller.impl.ComponentFactory.createInstance();
		analy_controll.setRequiredInterface(IAnalysisManagerTag, analyIAnaly);
		plann_controll = mapekcosmos.conn_planner_controller.impl.ComponentFactory.createInstance();
		plann_controll.setRequiredInterface(IPlanningManagerTag, plannIPlann);
		execu_controll = mapekcosmos.conn_executer_controller.impl.ComponentFactory.createInstance();
		execu_controll.setRequiredInterface(IExecutionManagerTag, execuIExecu);
		//setters to control
		controll.setRequiredInterface(IAnalysisManagerTag,
				analy_controll.getProvidedInterface(IAnalysisManagerTag));
		controll.setRequiredInterface(IPlanningManagerTag,
				plann_controll.getProvidedInterface(IPlanningManagerTag));
		controll.setRequiredInterface(IExecutionManagerTag,
				execu_controll.getProvidedInterface(IExecutionManagerTag));

		controllIControll = (mapekcosmos.controller.prov.IControllerManager) controll
				.getProvidedInterface(IControllerManagerTag);

		//***********************To the application

		client = unicamp.buscame.client.impl.ComponentFactory.createInstance();
		clientIClient =
				(unicamp.buscame.client.prov.IClientManager) client.getProvidedInterface(IClientManagerTag);
		product = unicamp.buscame.product.impl.ComponentFactory.createInstance();
		productIProd =
				(unicamp.buscame.product.prov.IProductManager) product.getProvidedInterface(IProductManagerTag);
		configuration = unicamp.buscame.configuration.impl.ComponentFactory.createInstance();
		configurationIConf =
				(unicamp.buscame.configuration.prov.IConfigurationManager) configuration.getProvidedInterface(IConfigurationManagerTag);
		localization = unicamp.buscame.localization.impl.ComponentFactory.createInstance();
		localizationILoca =
				(unicamp.buscame.localization.prov.ILocalizationManager) localization.getProvidedInterface(ILocalizationManagerTag);


		company = unicamp.buscame.company.impl.ComponentFactory.createInstance();
		//connectors to company
		configuration_company = unicamp.buscame.conn_configuration_company.impl.ComponentFactory.createInstance();
		configuration_company.setRequiredInterface(IConfigurationManagerTag, configurationIConf);
		product_company = unicamp.buscame.conn_product_company.impl.ComponentFactory.createInstance();
		product_company.setRequiredInterface(IProductManagerTag, productIProd);
		localization_company = unicamp.buscame.conn_localization_company.impl.ComponentFactory.createInstance();
		localization_company.setRequiredInterface(ILocalizationManagerTag, localizationILoca);
		//setters to control
		company.setRequiredInterface(IConfigurationManagerTag,
				configuration_company.getProvidedInterface(IConfigurationManagerTag));
		company.setRequiredInterface(IProductManagerTag,
				product_company.getProvidedInterface(IProductManagerTag));
		company.setRequiredInterface(ILocalizationManagerTag,
				localization_company.getProvidedInterface(ILocalizationManagerTag));
		companyIComp =
				(unicamp.buscame.company.prov.ICompanyManager) company.getProvidedInterface(ICompanyManagerTag);

		ui = unicamp.buscame.ui.impl.ComponentFactory.createInstance();
		client_ui= unicamp.buscame.conn_client_ui.impl.ComponentFactory.createInstance();
		client_ui.setRequiredInterface(IClientManagerTag, clientIClient);
		company_ui= unicamp.buscame.conn_company_ui.impl.ComponentFactory.createInstance();
		company_ui.setRequiredInterface(ICompanyManagerTag, companyIComp);
		//setters to control
		ui.setRequiredInterface(IClientManagerTag,
				client_ui.getProvidedInterface(IClientManagerTag));
		ui.setRequiredInterface(ICompanyManagerTag,
				company_ui.getProvidedInterface(ICompanyManagerTag));
		uiIUi =
				(unicamp.buscame.ui.prov.IUiManager) ui.getProvidedInterface(IUiManagerTag);

		controller = unicamp.buscame.controller.impl.ComponentFactory.createInstance();
		client_controller = unicamp.buscame.conn_client_controller.impl.ComponentFactory.createInstance();
		client_controller.setRequiredInterface(IClientManagerTag, clientIClient);
		company_controller=unicamp.buscame.conn_company_controller.impl.ComponentFactory.createInstance();
		company_controller.setRequiredInterface(ICompanyManagerTag, companyIComp);
		ui_controller=unicamp.buscame.conn_ui_controller.impl.ComponentFactory.createInstance();
		ui_controller.setRequiredInterface(IUiManagerTag, uiIUi);
		//setters to control
		controller.setRequiredInterface(IClientManagerTag,
				client_controller.getProvidedInterface(IClientManagerTag));
		controller.setRequiredInterface(ICompanyManagerTag,
				company_controller.getProvidedInterface(ICompanyManagerTag));
		controller.setRequiredInterface(IUiManagerTag,
				ui_controller.getProvidedInterface(IUiManagerTag));
		controllerIContr =
				(unicamp.buscame.controller.prov.IControllerManager) controller.getProvidedInterface(IControllerManagerTag);

		//MANAGE DEPENDENCIES.
		productB = unicamp.buscame.productB.impl.ComponentFactory.createInstance();
		productBIProd =
				(unicamp.buscame.productB.prov.IProductManager) productB.getProvidedInterface(IProductManagerTag);

		productC = unicamp.buscame.productC.impl.ComponentFactory.createInstance();
		productCIProd =
				(unicamp.buscame.productC.prov.IProductManager) productC.getProvidedInterface(IProductManagerTag);

		localizationB = unicamp.buscame.localizationB.impl.ComponentFactory.createInstance();
		localizationBILoca =
				(unicamp.buscame.localizationB.prov.ILocalizationManager) localizationB.getProvidedInterface(ILocalizationManagerTag);

		localizationC = unicamp.buscame.localizationC.impl.ComponentFactory.createInstance();
		localizationCILoca =
				(unicamp.buscame.localizationC.prov.ILocalizationManager) localizationC.getProvidedInterface(ILocalizationManagerTag);

		configurationB = unicamp.buscame.configurationB.impl.ComponentFactory.createInstance();
		configurationBIConf =
				(unicamp.buscame.configurationB.prov.IConfigurationManager) configurationB.getProvidedInterface(IConfigurationManagerTag);
		//
		configurationB_company = unicamp.buscame.conn_configurationB_company.impl.ComponentFactory.createInstance();
		configurationB_company.setRequiredInterface(IConfigurationManagerTag, configurationBIConf);

		productB_company = unicamp.buscame.conn_productB_company.impl.ComponentFactory.createInstance();
		productB_company.setRequiredInterface(IProductManagerTag, productBIProd);

		productC_company = unicamp.buscame.conn_productC_company.impl.ComponentFactory.createInstance();
		productC_company.setRequiredInterface(IProductManagerTag, productCIProd);

		localizationB_company = unicamp.buscame.conn_localizationB_company.impl.ComponentFactory.createInstance();
		localizationB_company.setRequiredInterface(ILocalizationManagerTag, localizationBILoca);

		localizationC_company = unicamp.buscame.conn_localizationC_company.impl.ComponentFactory.createInstance();
		localizationC_company.setRequiredInterface(ILocalizationManagerTag, localizationCILoca);

	}
}
