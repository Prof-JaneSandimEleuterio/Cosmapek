package api;

/**
 * Created by ArchyWin on 8/25/2015.
 */
public interface RouteTags {

    final String Route_Companies = "/companies"; // important
    final String Route_Companies_ = "/companies/";
    final String Route_Companies_id = "/companies/{companyId}";
    final String Route_Companies_id_Configurations_ = "/companies/{companyId}/configurations/";
    final String Route_Companies_id_Products_ = "/companies/{companyId}/products/";

    final String Route_Companies_id_OperationHour_ = "/companies/{companyId}/operationHour/";
    final String Route_Companies_id_ProductGroups_ = "/companies/{companyId}/productGroups/";
    final String Route_Companies_id_ProductGroups_id = "/companies/{companyId}/productGroups/{productGroupId}";
    final String Route_Companies_id_ProductGroups_id_Products_ = "/companies/{companyId}/productGroups/{productGroupId}/products/";

    final String Route_Companies_id_Localizations_ = "/companies/{companyId}/localizations/";

    final String Route_Clients = "/clients"; // important
    final String Route_Clients_ = "/clients/";
    final String Route_Clients_id = "/clients/{clientId}";
    final String Route_Clients_id_Configurations_ = "/clients/{clientId}/configurations/";
    final String Route_Clients_id_Localizations_ = "/clients/{clientId}/Localizations/";

    final String Route_Products = "/products"; // important
    final String Route_products_ = "/products/";
    final String Route_products_id = "/products/{productId}";

    final String Route_Images = "/images"; // important
    final String Route_Images_ = "/images/";
    final String Route_Images_id = "/images/{imageId}";

}
