package com.softuvo.cloudsight.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Text;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.net.URL;
import java.util.List;

@Root(name="ItemSearchResponse", strict = false)
public class ItemSearchResponse {

    @Element(name="OperationRequest", required=false)
    OperationRequest operationRequest;

    @Element(name="Items", required=false)
    Items items;

    public OperationRequest getOperationRequest() {return this.operationRequest;}
    public void setOperationRequest(OperationRequest value) {this.operationRequest = value;}

    public Items getItems() {return this.items;}
    public void setItems(Items value) {this.items = value;}

    public static class HTTPHeaders {

        @Element(name="Header", required=false)
        Header header;

        public Header getHeader() {return this.header;}
        public void setHeader(Header value) {this.header = value;}

    }

    public static class Argument {

        @Attribute(name="Value", required=false)
        String value;

        @Attribute(name="Name", required=false)
        String name;

        public String getValue() {return this.value;}
        public void setValue(String value) {this.value = value;}

        public String getName() {return this.name;}
        public void setName(String value) {this.name = value;}

    }

    public static class OfferAttributes {

        @Element(name="Condition", required=false)
        String condition;

        public String getCondition() {return this.condition;}
        public void setCondition(String value) {this.condition = value;}

    }

    public static class LowestRefurbishedPrice {

        @Element(name="CurrencyCode", required=false)
        String currencyCode;

        @Element(name="Amount", required=false)
        String amount;

        @Element(name="FormattedPrice", required=false)
        String formattedPrice;

        public String getCurrencyCode() {return this.currencyCode;}
        public void setCurrencyCode(String value) {this.currencyCode = value;}

        public String getAmount() {return this.amount;}
        public void setAmount(String value) {this.amount = value;}

        public String getFormattedPrice() {return this.formattedPrice;}
        public void setFormattedPrice(String value) {this.formattedPrice = value;}

    }

    public static class ItemLink {

        @Element(name="Description", required=false)
        String description;

        @Element(name="URL", required=false)
        String uRL;

        public String getDescription() {return this.description;}
        public void setDescription(String value) {this.description = value;}

        public String getURL() {return this.uRL;}
        public void setURL(String value) {this.uRL = value;}

    }

    public static class ListPrice {

        @Element(name="CurrencyCode", required=false)
        String currencyCode;

        @Element(name="Amount", required=false)
        String amount;

        @Element(name="FormattedPrice", required=false)
        String formattedPrice;

        public String getCurrencyCode() {return this.currencyCode;}
        public void setCurrencyCode(String value) {this.currencyCode = value;}

        public String getAmount() {return this.amount;}
        public void setAmount(String value) {this.amount = value;}

        public String getFormattedPrice() {return this.formattedPrice;}
        public void setFormattedPrice(String value) {this.formattedPrice = value;}

    }

    public static class MediumImage {

        @Element(name="Height", required=false)
        Height height;

        @Element(name="Width", required=false)
        Width width;

        @Element(name="URL", required=false)
        String uRL;

        public Height getHeight() {return this.height;}
        public void setHeight(Height value) {this.height = value;}

        public Width getWidth() {return this.width;}
        public void setWidth(Width value) {this.width = value;}

        public String getURL() {return this.uRL;}
        public void setURL(String value) {this.uRL = value;}

    }

    public static class CatalogNumberList {

        @Element(name="CatalogNumberListElement", required=false)
        String catalogNumberListElement;

        public String getCatalogNumberListElement() {return this.catalogNumberListElement;}
        public void setCatalogNumberListElement(String value) {this.catalogNumberListElement = value;}

    }

    public static class UPCList {

        @Element(name="UPCListElement", required=false)
        String uPCListElement;

        public String getUPCListElement() {return this.uPCListElement;}
        public void setUPCListElement(String value) {this.uPCListElement = value;}

    }

    public static class Item {

        @Element(name="ParentASIN", required=false)
        String parentASIN;

        @Element(name="DetailPageURL", required=false)
        String detailPageURL;

        @Element(name="OfferSummary", required=false)
        OfferSummary offerSummary;

        @Element(name="LargeImage", required=false)
        LargeImage largeImage;

        @ElementList(name="ImageSets", required=false)
        List<ImageSets> imageSets;

        @ElementList(name="ItemLinks", required=false)
        List<ItemLink> itemLinks;

        @Element(name="ASIN", required=false)
        String aSIN;

        @Element(name="ItemAttributes", required=false)
        ItemAttributes itemAttributes;

        @Element(name="Offers", required=false)
        Offers offers;

        @Element(name="SmallImage", required=false)
        SmallImage smallImage;

        @Element(name="MediumImage", required=false)
        MediumImage mediumImage;

        public String getParentASIN() {return this.parentASIN;}
        public void setParentASIN(String value) {this.parentASIN = value;}

        public String getDetailPageURL() {return this.detailPageURL;}
        public void setDetailPageURL(String value) {this.detailPageURL = value;}

        public OfferSummary getOfferSummary() {return this.offerSummary;}
        public void setOfferSummary(OfferSummary value) {this.offerSummary = value;}

        public LargeImage getLargeImage() {return this.largeImage;}
        public void setLargeImage(LargeImage value) {this.largeImage = value;}

        public List<ImageSets> getImageSets() {return this.imageSets;}
        public void setImageSets(List<ImageSets> value) {this.imageSets = value;}

        public List<ItemLink> getItemLinks() {return this.itemLinks;}
        public void setItemLinks(List<ItemLink> value) {this.itemLinks = value;}

        public String getASIN() {return this.aSIN;}
        public void setASIN(String value) {this.aSIN = value;}

        public ItemAttributes getItemAttributes() {return this.itemAttributes;}
        public void setItemAttributes(ItemAttributes value) {this.itemAttributes = value;}

        public Offers getOffers() {return this.offers;}
        public void setOffers(Offers value) {this.offers = value;}

        public SmallImage getSmallImage() {return this.smallImage;}
        public void setSmallImage(SmallImage value) {this.smallImage = value;}

        public MediumImage getMediumImage() {return this.mediumImage;}
        public void setMediumImage(MediumImage value) {this.mediumImage = value;}

    }

    public static class PackageDimensions {

        @Element(name="Length", required=false)
        Length length;

        @Element(name="Height", required=false)
        Height height;

        @Element(name="Width", required=false)
        Width width;

        @Element(name="Weight", required=false)
        Weight weight;

        public Length getLength() {return this.length;}
        public void setLength(Length value) {this.length = value;}

        public Height getHeight() {return this.height;}
        public void setHeight(Height value) {this.height = value;}

        public Width getWidth() {return this.width;}
        public void setWidth(Width value) {this.width = value;}

        public Weight getWeight() {return this.weight;}
        public void setWeight(Weight value) {this.weight = value;}

    }

    public static class EANList {

        @Element(name="EANListElement", required=false)
        String eANListElement;

        public String getEANListElement() {return this.eANListElement;}
        public void setEANListElement(String value) {this.eANListElement = value;}

    }

    public static class Items {

        @ElementList(name="Item", required=false, entry="Item", inline=true)
        List<Item> item;

        @Element(name="Request", required=false)
        Request request;

        @Element(name="TotalResults", required=false)
        String totalResults;

        @Element(name="TotalPages", required=false)
        String totalPages;

        @Element(name="MoreSearchResultsUrl", required=false)
        String moreSearchResultsUrl;

        public List<Item> getItem() {return this.item;}
        public void setItem(List<Item> value) {this.item = value;}

        public Request getRequest() {return this.request;}
        public void setRequest(Request value) {this.request = value;}

        public String getTotalResults() {return this.totalResults;}
        public void setTotalResults(String value) {this.totalResults = value;}

        public String getTotalPages() {return this.totalPages;}
        public void setTotalPages(String value) {this.totalPages = value;}

        public String getMoreSearchResultsUrl() {return this.moreSearchResultsUrl;}
        public void setMoreSearchResultsUrl(String value) {this.moreSearchResultsUrl = value;}

    }

    public static class Height {

        @Text(required=false)
        String textValue;

        @Attribute(name="Units", required=false)
        String units;

        public String getTextValue() {return this.textValue;}
        public void setTextValue(String value) {this.textValue = value;}

        public String getUnits() {return this.units;}
        public void setUnits(String value) {this.units = value;}

    }

    public static class LowestUsedPrice {

        @Element(name="CurrencyCode", required=false)
        String currencyCode;

        @Element(name="Amount", required=false)
        String amount;

        @Element(name="FormattedPrice", required=false)
        String formattedPrice;

        public String getCurrencyCode() {return this.currencyCode;}
        public void setCurrencyCode(String value) {this.currencyCode = value;}

        public String getAmount() {return this.amount;}
        public void setAmount(String value) {this.amount = value;}

        public String getFormattedPrice() {return this.formattedPrice;}
        public void setFormattedPrice(String value) {this.formattedPrice = value;}

    }

    public static class SmallImage {

        @Element(name="Height", required=false)
        Height height;

        @Element(name="Width", required=false)
        Width width;

        @Element(name="URL", required=false)
        String uRL;

        public Height getHeight() {return this.height;}
        public void setHeight(Height value) {this.height = value;}

        public Width getWidth() {return this.width;}
        public void setWidth(Width value) {this.width = value;}

        public String getURL() {return this.uRL;}
        public void setURL(String value) {this.uRL = value;}

    }

    public static class Width {

        @Text(required=false)
        String textValue;

        @Attribute(name="Units", required=false)
        String units;

        public String getTextValue() {return this.textValue;}
        public void setTextValue(String value) {this.textValue = value;}

        public String getUnits() {return this.units;}
        public void setUnits(String value) {this.units = value;}

    }

    public static class OfferListing {

        @Element(name="Availability", required=false)
        String availability;

        @Element(name="OfferListingId", required=false)
        String offerListingId;

        @Element(name="IsEligibleForSuperSaverShipping", required=false)
        String isEligibleForSuperSaverShipping;

        @Element(name="AmountSaved", required=false)
        AmountSaved amountSaved;

        @Element(name="Price", required=false)
        Price price;

        @Element(name="PercentageSaved", required=false)
        String percentageSaved;

        @Element(name="SalePrice", required=false)
        SalePrice salePrice;

        @Element(name="IsEligibleForPrime", required=false)
        String isEligibleForPrime;

        @Element(name="AvailabilityAttributes", required=false)
        AvailabilityAttributes availabilityAttributes;

        public String getAvailability() {return this.availability;}
        public void setAvailability(String value) {this.availability = value;}

        public String getOfferListingId() {return this.offerListingId;}
        public void setOfferListingId(String value) {this.offerListingId = value;}

        public String getIsEligibleForSuperSaverShipping() {return this.isEligibleForSuperSaverShipping;}
        public void setIsEligibleForSuperSaverShipping(String value) {this.isEligibleForSuperSaverShipping = value;}

        public AmountSaved getAmountSaved() {return this.amountSaved;}
        public void setAmountSaved(AmountSaved value) {this.amountSaved = value;}

        public Price getPrice() {return this.price;}
        public void setPrice(Price value) {this.price = value;}

        public String getPercentageSaved() {return this.percentageSaved;}
        public void setPercentageSaved(String value) {this.percentageSaved = value;}

        public SalePrice getSalePrice() {return this.salePrice;}
        public void setSalePrice(SalePrice value) {this.salePrice = value;}

        public String getIsEligibleForPrime() {return this.isEligibleForPrime;}
        public void setIsEligibleForPrime(String value) {this.isEligibleForPrime = value;}

        public AvailabilityAttributes getAvailabilityAttributes() {return this.availabilityAttributes;}
        public void setAvailabilityAttributes(AvailabilityAttributes value) {this.availabilityAttributes = value;}

    }

    public static class AmountSaved {

        @Element(name="CurrencyCode", required=false)
        String currencyCode;

        @Element(name="Amount", required=false)
        String amount;

        @Element(name="FormattedPrice", required=false)
        String formattedPrice;

        public String getCurrencyCode() {return this.currencyCode;}
        public void setCurrencyCode(String value) {this.currencyCode = value;}

        public String getAmount() {return this.amount;}
        public void setAmount(String value) {this.amount = value;}

        public String getFormattedPrice() {return this.formattedPrice;}
        public void setFormattedPrice(String value) {this.formattedPrice = value;}

    }

    public static class TradeInValue {

        @Element(name="CurrencyCode", required=false)
        String currencyCode;

        @Element(name="Amount", required=false)
        String amount;

        @Element(name="FormattedPrice", required=false)
        String formattedPrice;

        public String getCurrencyCode() {return this.currencyCode;}
        public void setCurrencyCode(String value) {this.currencyCode = value;}

        public String getAmount() {return this.amount;}
        public void setAmount(String value) {this.amount = value;}

        public String getFormattedPrice() {return this.formattedPrice;}
        public void setFormattedPrice(String value) {this.formattedPrice = value;}

    }

    public static class SwatchImage {

        @Element(name="Height", required=false)
        Height height;

        @Element(name="Width", required=false)
        Width width;

        @Element(name="URL", required=false)
        String uRL;

        public Height getHeight() {return this.height;}
        public void setHeight(Height value) {this.height = value;}

        public Width getWidth() {return this.width;}
        public void setWidth(Width value) {this.width = value;}

        public String getURL() {return this.uRL;}
        public void setURL(String value) {this.uRL = value;}

    }

    public static class OperationRequest {

        @Element(name="HTTPHeaders", required=false)
        HTTPHeaders hTTPHeaders;

        @Element(name="RequestId", required=false)
        String requestId;

        @ElementList(name="Arguments", required=false)
        List<Argument> arguments;

        @Element(name="RequestProcessingTime", required=false)
        String requestProcessingTime;

        public HTTPHeaders getHTTPHeaders() {return this.hTTPHeaders;}
        public void setHTTPHeaders(HTTPHeaders value) {this.hTTPHeaders = value;}

        public String getRequestId() {return this.requestId;}
        public void setRequestId(String value) {this.requestId = value;}

        public List<Argument> getArguments() {return this.arguments;}
        public void setArguments(List<Argument> value) {this.arguments = value;}

        public String getRequestProcessingTime() {return this.requestProcessingTime;}
        public void setRequestProcessingTime(String value) {this.requestProcessingTime = value;}

    }

    public static class Request {

        @Element(name="ItemSearchRequest", required=false)
        ItemSearchRequest itemSearchRequest;

        @Element(name="IsValid", required=false)
        String isValid;

        public ItemSearchRequest getItemSearchRequest() {return this.itemSearchRequest;}
        public void setItemSearchRequest(ItemSearchRequest value) {this.itemSearchRequest = value;}

        public String getIsValid() {return this.isValid;}
        public void setIsValid(String value) {this.isValid = value;}

    }

    public static class Offers {

        @Element(name="TotalOfferPages", required=false)
        String totalOfferPages;

        @Element(name="Offer", required=false)
        Offer offer;

        @Element(name="MoreOffersUrl", required=false)
        String moreOffersUrl;

        @Element(name="TotalOffers", required=false)
        String totalOffers;

        public String getTotalOfferPages() {return this.totalOfferPages;}
        public void setTotalOfferPages(String value) {this.totalOfferPages = value;}

        public Offer getOffer() {return this.offer;}
        public void setOffer(Offer value) {this.offer = value;}

        public String getMoreOffersUrl() {return this.moreOffersUrl;}
        public void setMoreOffersUrl(String value) {this.moreOffersUrl = value;}

        public String getTotalOffers() {return this.totalOffers;}
        public void setTotalOffers(String value) {this.totalOffers = value;}

    }

    public static class Weight {

        @Text(required=false)
        String textValue;

        @Attribute(name="Units", required=false)
        String units;

        public String getTextValue() {return this.textValue;}
        public void setTextValue(String value) {this.textValue = value;}

        public String getUnits() {return this.units;}
        public void setUnits(String value) {this.units = value;}

    }

    public static class LowestNewPrice {

        @Element(name="CurrencyCode", required=false)
        String currencyCode;

        @Element(name="Amount", required=false)
        String amount;

        @Element(name="FormattedPrice", required=false)
        String formattedPrice;

        public String getCurrencyCode() {return this.currencyCode;}
        public void setCurrencyCode(String value) {this.currencyCode = value;}

        public String getAmount() {return this.amount;}
        public void setAmount(String value) {this.amount = value;}

        public String getFormattedPrice() {return this.formattedPrice;}
        public void setFormattedPrice(String value) {this.formattedPrice = value;}

    }

    public static class OfferSummary {

        @Element(name="TotalCollectible", required=false)
        String totalCollectible;

        @Element(name="TotalRefurbished", required=false)
        String totalRefurbished;

        @Element(name="LowestRefurbishedPrice", required=false)
        LowestRefurbishedPrice lowestRefurbishedPrice;

        @Element(name="TotalUsed", required=false)
        String totalUsed;

        @Element(name="LowestUsedPrice", required=false)
        LowestUsedPrice lowestUsedPrice;

        @Element(name="TotalNew", required=false)
        String totalNew;

        @Element(name="LowestNewPrice", required=false)
        LowestNewPrice lowestNewPrice;

        public String getTotalCollectible() {return this.totalCollectible;}
        public void setTotalCollectible(String value) {this.totalCollectible = value;}

        public String getTotalRefurbished() {return this.totalRefurbished;}
        public void setTotalRefurbished(String value) {this.totalRefurbished = value;}

        public LowestRefurbishedPrice getLowestRefurbishedPrice() {return this.lowestRefurbishedPrice;}
        public void setLowestRefurbishedPrice(LowestRefurbishedPrice value) {this.lowestRefurbishedPrice = value;}

        public String getTotalUsed() {return this.totalUsed;}
        public void setTotalUsed(String value) {this.totalUsed = value;}

        public LowestUsedPrice getLowestUsedPrice() {return this.lowestUsedPrice;}
        public void setLowestUsedPrice(LowestUsedPrice value) {this.lowestUsedPrice = value;}

        public String getTotalNew() {return this.totalNew;}
        public void setTotalNew(String value) {this.totalNew = value;}

        public LowestNewPrice getLowestNewPrice() {return this.lowestNewPrice;}
        public void setLowestNewPrice(LowestNewPrice value) {this.lowestNewPrice = value;}

    }

    public static class Header {

        @Attribute(name="Value", required=false)
        String value;

        @Attribute(name="Name", required=false)
        String name;

        public String getValue() {return this.value;}
        public void setValue(String value) {this.value = value;}

        public String getName() {return this.name;}
        public void setName(String value) {this.name = value;}

    }

    public static class LargeImage {

        @Element(name="Height", required=false)
        Height height;

        @Element(name="Width", required=false)
        Width width;

        @Element(name="URL", required=false)
        String uRL;

        public Height getHeight() {return this.height;}
        public void setHeight(Height value) {this.height = value;}

        public Width getWidth() {return this.width;}
        public void setWidth(Width value) {this.width = value;}

        public String getURL() {return this.uRL;}
        public void setURL(String value) {this.uRL = value;}

    }

    public static class TinyImage {

        @Element(name="Height", required=false)
        Height height;

        @Element(name="Width", required=false)
        Width width;

        @Element(name="URL", required=false)
        String uRL;

        public Height getHeight() {return this.height;}
        public void setHeight(Height value) {this.height = value;}

        public Width getWidth() {return this.width;}
        public void setWidth(Width value) {this.width = value;}

        public String getURL() {return this.uRL;}
        public void setURL(String value) {this.uRL = value;}

    }

    public static class Length {

        @Text(required=false)
        String textValue;

        @Attribute(name="Units", required=false)
        String units;

        public String getTextValue() {return this.textValue;}
        public void setTextValue(String value) {this.textValue = value;}

        public String getUnits() {return this.units;}
        public void setUnits(String value) {this.units = value;}

    }

    public static class Offer {

        @Element(name="OfferListing", required=false)
        OfferListing offerListing;

        @Element(name="OfferAttributes", required=false)
        OfferAttributes offerAttributes;

        public OfferListing getOfferListing() {return this.offerListing;}
        public void setOfferListing(OfferListing value) {this.offerListing = value;}

        public OfferAttributes getOfferAttributes() {return this.offerAttributes;}
        public void setOfferAttributes(OfferAttributes value) {this.offerAttributes = value;}

    }

    public static class Price {

        @Element(name="CurrencyCode", required=false)
        String currencyCode;

        @Element(name="Amount", required=false)
        String amount;

        @Element(name="FormattedPrice", required=false)
        String formattedPrice;

        public String getCurrencyCode() {return this.currencyCode;}
        public void setCurrencyCode(String value) {this.currencyCode = value;}

        public String getAmount() {return this.amount;}
        public void setAmount(String value) {this.amount = value;}

        public String getFormattedPrice() {return this.formattedPrice;}
        public void setFormattedPrice(String value) {this.formattedPrice = value;}

    }

    public static class ImageSets {

        @Element(name="ImageSet", required=false)
        ImageSet imageSet;

        public ImageSet getImageSet() {return this.imageSet;}
        public void setImageSet(ImageSet value) {this.imageSet = value;}

    }

    public static class ThumbnailImage {

        @Element(name="Height", required=false)
        Height height;

        @Element(name="Width", required=false)
        Width width;

        @Element(name="URL", required=false)
        String uRL;

        public Height getHeight() {return this.height;}
        public void setHeight(Height value) {this.height = value;}

        public Width getWidth() {return this.width;}
        public void setWidth(Width value) {this.width = value;}

        public String getURL() {return this.uRL;}
        public void setURL(String value) {this.uRL = value;}

    }

    public static class ItemDimensions {

        @Element(name="Length", required=false)
        Length length;

        @Element(name="Height", required=false)
        Height height;

        @Element(name="Width", required=false)
        Width width;

        @Element(name="Weight", required=false)
        Weight weight;

        public Length getLength() {return this.length;}
        public void setLength(Length value) {this.length = value;}

        public Height getHeight() {return this.height;}
        public void setHeight(Height value) {this.height = value;}

        public Width getWidth() {return this.width;}
        public void setWidth(Width value) {this.width = value;}

        public Weight getWeight() {return this.weight;}
        public void setWeight(Weight value) {this.weight = value;}

    }

    public static class ItemAttributes {

        @Element(name="OperatingSystem", required=false)
        String operatingSystem;

        @Element(name="ProductGroup", required=false)
        String productGroup;

        @Element(name="HazardousMaterialType", required=false)
        String hazardousMaterialType;

        @Element(name="PartNumber", required=false)
        String partNumber;

        @Element(name="Size", required=false)
        String size;

        @Element(name="Label", required=false)
        String label;

        @Element(name="UPC", required=false)
        String uPC;

        @Element(name="MPN", required=false)
        String mPN;

        @Element(name="ListPrice", required=false)
        ListPrice listPrice;

        @ElementList(name="Feature", required=false, entry="Feature", inline=true)
        List<String> feature;

        @Element(name="Studio", required=false)
        String studio;

        @Element(name="CatalogNumberList", required=false)
        CatalogNumberList catalogNumberList;

        @ElementList(name="UPCList", required=false)
        List<UPCList> uPCList;

        @Element(name="Department", required=false)
        String department;

        @Element(name="PackageDimensions", required=false)
        PackageDimensions packageDimensions;

        @ElementList(name="EANList", required=false)
        List<EANList> eANList;

        @Element(name="Manufacturer", required=false)
        String manufacturer;

        @Element(name="Binding", required=false)
        String binding;

        @Element(name="TradeInValue", required=false)
        TradeInValue tradeInValue;

        @Element(name="Color", required=false)
        String color;

        @Element(name="Title", required=false)
        String title;

        @Element(name="LegalDisclaimer", required=false)
        String legalDisclaimer;

        @Element(name="ProductTypeName", required=false)
        String productTypeName;

        @Element(name="Publisher", required=false)
        String publisher;

        @Element(name="PackageQuantity", required=false)
        String packageQuantity;

        @Element(name="Edition", required=false)
        String edition;

        @Element(name="Brand", required=false)
        String brand;

        @Element(name="EAN", required=false)
        String eAN;

        @Element(name="IsEligibleForTradeIn", required=false)
        String isEligibleForTradeIn;

        @Element(name="NumberOfItems", required=false)
        String numberOfItems;

        @Element(name="ItemDimensions", required=false)
        ItemDimensions itemDimensions;

        @Element(name="Model", required=false)
        String model;

        public String getOperatingSystem() {return this.operatingSystem;}
        public void setOperatingSystem(String value) {this.operatingSystem = value;}

        public String getProductGroup() {return this.productGroup;}
        public void setProductGroup(String value) {this.productGroup = value;}

        public String getHazardousMaterialType() {return this.hazardousMaterialType;}
        public void setHazardousMaterialType(String value) {this.hazardousMaterialType = value;}

        public String getPartNumber() {return this.partNumber;}
        public void setPartNumber(String value) {this.partNumber = value;}

        public String getSize() {return this.size;}
        public void setSize(String value) {this.size = value;}

        public String getLabel() {return this.label;}
        public void setLabel(String value) {this.label = value;}

        public String getUPC() {return this.uPC;}
        public void setUPC(String value) {this.uPC = value;}

        public String getMPN() {return this.mPN;}
        public void setMPN(String value) {this.mPN = value;}

        public ListPrice getListPrice() {return this.listPrice;}
        public void setListPrice(ListPrice value) {this.listPrice = value;}

        public List<String> getFeature() {return this.feature;}
        public void setFeature(List<String> value) {this.feature = value;}

        public String getStudio() {return this.studio;}
        public void setStudio(String value) {this.studio = value;}

        public CatalogNumberList getCatalogNumberList() {return this.catalogNumberList;}
        public void setCatalogNumberList(CatalogNumberList value) {this.catalogNumberList = value;}

        public List<UPCList> getUPCList() {return this.uPCList;}
        public void setUPCList(List<UPCList> value) {this.uPCList = value;}

        public String getDepartment() {return this.department;}
        public void setDepartment(String value) {this.department = value;}

        public PackageDimensions getPackageDimensions() {return this.packageDimensions;}
        public void setPackageDimensions(PackageDimensions value) {this.packageDimensions = value;}

        public List<EANList> getEANList() {return this.eANList;}
        public void setEANList(List<EANList> value) {this.eANList = value;}

        public String getManufacturer() {return this.manufacturer;}
        public void setManufacturer(String value) {this.manufacturer = value;}

        public String getBinding() {return this.binding;}
        public void setBinding(String value) {this.binding = value;}

        public TradeInValue getTradeInValue() {return this.tradeInValue;}
        public void setTradeInValue(TradeInValue value) {this.tradeInValue = value;}

        public String getColor() {return this.color;}
        public void setColor(String value) {this.color = value;}

        public String getTitle() {return this.title;}
        public void setTitle(String value) {this.title = value;}

        public String getLegalDisclaimer() {return this.legalDisclaimer;}
        public void setLegalDisclaimer(String value) {this.legalDisclaimer = value;}

        public String getProductTypeName() {return this.productTypeName;}
        public void setProductTypeName(String value) {this.productTypeName = value;}

        public String getPublisher() {return this.publisher;}
        public void setPublisher(String value) {this.publisher = value;}

        public String getPackageQuantity() {return this.packageQuantity;}
        public void setPackageQuantity(String value) {this.packageQuantity = value;}

        public String getEdition() {return this.edition;}
        public void setEdition(String value) {this.edition = value;}

        public String getBrand() {return this.brand;}
        public void setBrand(String value) {this.brand = value;}

        public String getEAN() {return this.eAN;}
        public void setEAN(String value) {this.eAN = value;}

        public String getIsEligibleForTradeIn() {return this.isEligibleForTradeIn;}
        public void setIsEligibleForTradeIn(String value) {this.isEligibleForTradeIn = value;}

        public String getNumberOfItems() {return this.numberOfItems;}
        public void setNumberOfItems(String value) {this.numberOfItems = value;}

        public ItemDimensions getItemDimensions() {return this.itemDimensions;}
        public void setItemDimensions(ItemDimensions value) {this.itemDimensions = value;}

        public String getModel() {return this.model;}
        public void setModel(String value) {this.model = value;}

    }

    public static class ItemSearchRequest {

        @Element(name="Keywords", required=false)
        String keywords;

        @ElementList(name="ResponseGroup", required=false, entry="ResponseGroup", inline=true)
        List<String> responseGroup;

        @Element(name="SearchIndex", required=false)
        String searchIndex;

        public String getKeywords() {return this.keywords;}
        public void setKeywords(String value) {this.keywords = value;}

        public List<String> getResponseGroup() {return this.responseGroup;}
        public void setResponseGroup(List<String> value) {this.responseGroup = value;}

        public String getSearchIndex() {return this.searchIndex;}
        public void setSearchIndex(String value) {this.searchIndex = value;}

    }



    public static class ImageSet {

        @Attribute(name="Category", required=false)
        String category;

        @Element(name="TinyImage", required=false)
        TinyImage tinyImage;

        @Element(name="LargeImage", required=false)
        LargeImage largeImage;

        @Element(name="ThumbnailImage", required=false)
        ThumbnailImage thumbnailImage;

        @Element(name="SwatchImage", required=false)
        SwatchImage swatchImage;

        @Element(name="SmallImage", required=false)
        SmallImage smallImage;

        @Element(name="MediumImage", required=false)
        MediumImage mediumImage;

        public String getCategory() {return this.category;}
        public void setCategory(String value) {this.category = value;}

        public TinyImage getTinyImage() {return this.tinyImage;}
        public void setTinyImage(TinyImage value) {this.tinyImage = value;}

        public LargeImage getLargeImage() {return this.largeImage;}
        public void setLargeImage(LargeImage value) {this.largeImage = value;}

        public ThumbnailImage getThumbnailImage() {return this.thumbnailImage;}
        public void setThumbnailImage(ThumbnailImage value) {this.thumbnailImage = value;}

        public SwatchImage getSwatchImage() {return this.swatchImage;}
        public void setSwatchImage(SwatchImage value) {this.swatchImage = value;}

        public SmallImage getSmallImage() {return this.smallImage;}
        public void setSmallImage(SmallImage value) {this.smallImage = value;}

        public MediumImage getMediumImage() {return this.mediumImage;}
        public void setMediumImage(MediumImage value) {this.mediumImage = value;}

    }

    public static class SalePrice {

        @Element(name="CurrencyCode", required=false)
        String currencyCode;

        @Element(name="Amount", required=false)
        String amount;

        @Element(name="FormattedPrice", required=false)
        String formattedPrice;

        public String getCurrencyCode() {return this.currencyCode;}
        public void setCurrencyCode(String value) {this.currencyCode = value;}

        public String getAmount() {return this.amount;}
        public void setAmount(String value) {this.amount = value;}

        public String getFormattedPrice() {return this.formattedPrice;}
        public void setFormattedPrice(String value) {this.formattedPrice = value;}

    }

    public static class AvailabilityAttributes {

        @Element(name="MinimumHours", required=false)
        String minimumHours;

        @Element(name="MaximumHours", required=false)
        String maximumHours;

        @Element(name="AvailabilityType", required=false)
        String availabilityType;

        public String getMinimumHours() {return this.minimumHours;}
        public void setMinimumHours(String value) {this.minimumHours = value;}

        public String getMaximumHours() {return this.maximumHours;}
        public void setMaximumHours(String value) {this.maximumHours = value;}

        public String getAvailabilityType() {return this.availabilityType;}
        public void setAvailabilityType(String value) {this.availabilityType = value;}

    }

}