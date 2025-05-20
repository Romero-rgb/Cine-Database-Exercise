public class Constants {
    public static final String SUPERMARKETS_FILE_NAME = "supermarkets.txt";
    public static final String PRODUCTS_FILE_NAME = "products.txt";
    public static final String DEFAULT_DATA_DIRECTORY = "data";
    public static final String MESSAGE_DEFAULT_ASK_STRING = "Introdueixi una cadena de text";
    public static final String MESSAGE_DEFAULT_ERROR_STRING = "S'ha introduït un text buit";
    public static final String MESSAGE_DEFAULT_ASK_INTEGER = "Introdueixi un valor enter";
    public static final String MESSAGE_DEFAULT_ERROR_INTEGER = "El valor introduït no correspon a un enter";
    public static final String MESSAGE_DEFAULT_ASK_FLOAT = "Introdueixi un valor amb decimals per l'opció";
    public static final String MESSAGE_DEFAULT_ERROR_FLOAT = "El valor introduït no correspon a un nombre amb decimals";
    public static final String ERROR_NO_INTEGER = "Error no s'ha introduït un enter";
    public static final String ERROR_FILE_NAME_NULL = "El nom de l'arxiu no pot ser null o buit";
    public static final String ERROR_STRING_NULL = "L'String no pot ser null o buit";
    public static final String ERROR_PRODUCT_NULL = "El producte no pot ser null o buit";
    public static final String ERROR_NEGATIVE_PRICE = "El preu no pot ser negatiu";
    public static final String ERROR_NEGATIVE_STOCK = "L'Stock no pot ser negatiu";
    public static final String ERROR_NAME_PRODUCT_NULL = "El nom del producte no pot ser null o buit";
    public static final String ERROR_BRAND_PRODUCT_NULL = "La marca del producte no pot ser null o buit";
    public static final String ERROR_PRODUCT_EXISTS = "El producte ja existeix";
    public static final String ERROR_PRODUCT_NOT_EXISTS = "El producte no existeix";
    public static final String ERROR_SUPERMARKET_NULL = "El supermercat no pot ser null o buit";
    public static final String ERROR_SUPERMARKET_EXISTS = "El supermercat ja existeix";
    public static final String ERROR_SUPERMARKET_NOT_EXISTS = "El supermercat no existeix";
    public static final String ERROR_DECREMENT_STOCK = "No n'hi ha suficient stock per decrementar";
    public static final String ERROR_FILE_EXISTS = "El nom de l'arxiu ja existeix";
    public static final String ERROR_CREATING_FILE = "Error creant l'arxiu";
    public static final String ERROR_FILE_NOT_EXIST = "L'arxiu no existeix";
    public static final String ERROR_WRITING_FILE = "Error escrivint a l'arxiu";
    public static final String ERROR_CONTENT_NULL = "El contingut de l'arxiu no pot ser null o buit";
    public static final String ERROR_EXPIRATION_DATE_NULL_OR_EMPTY = "La data de caducitat no pot ser null o buit";
    public static final String ERROR_EXPIRATION_DATE_FORMAT = "El format de la data de caducitat no és correcte. Ha de ser \"yyyyMMdd\"";
    public static final String ERROR_COUNTRY = "El pais no pot ser nullo buit";    
    public static final String ERROR_SUPERMARKET_LIST_EMPTY = "La llista de supermercat es buida";
    public static final String TYPE_COSMETIC = "COSMETIC";
    public static final String TYPE_FOOD = "FOOD";
    public static final String MESSAGE_SEPARATOR = "--------------------------------------------------------------------------------------------------------------";
    public static final String START_MENU_HEADER = "GESTIO IOC SUPERMARKETS";  
    public final static String LIST_HEADER = "SUPERMARKET                   CITY                            LONGITUDE   LATITUDE";
    public final static String TEMP_LIN = "-----------------------------------------------------------------------------------";
    public static final String START_MENU = """
        1) Afegir supermercat.
        2) Afegir producte a un supermercat.
        3) Veure supermercats.
        4) Exportar supermercats i preus.
        5) Importar supermercats i preus.
        0) Sortir.
        """;    
    public final static String SUPERMARKET_BOARD_FORMAT = "%-28s  %-29s %11.7f %11.7f";
    public final static String SUPERMARKET_FORMAT = "%s,%s,%.7f,%.7f";    
    public final static String PRODUCT_FORMAT = "%s,%.2f,%d";
    public static final String DATE_FORMAT = "yyyyMMdd";
    public static final String LINE_BREAK = "\n";
    public static final String EMPTY_SPACE = "";
    public static final String ERROR_HEADER = "ERROR";   
    public static final String INFO_HEADER = "INFO";   
    public static final int DAYS_CLOSE_TO_EXPIRATION = 7;
    public static final int FOOD_PRODUCT_EXPIRATION_DISCOUNT = 20;
    public static final String ERROR_EXPIRATION_DATE_PAST = "La data de caducitat no pot ser anterior a la data actual";
    public static final String MESSAGE_INSERT_EXPIRATION_DATE = "Introdueix la data de caducitat (yyyyMMdd):";
    public static final float MAX_PERCENTAGE = 100.0f;
    public static final float MIN_PERCENTAGE = 0.0f;
    public static final String ERROR_DISCOUNT_OUT_OF_RANGE = "El descompte ha de ser entre 0 i 100";
    public static final String ERROR_NOT_VALID_OPTION = "Selecciona una opció vàlida";
    public static final String MESSAGE_BYE_BYE = "Gràcies per fer ús del meu programa, espero que sigui de deu! ;)\nPrograma fet per Antonio Fernàndez";
    public static final String MESSAGE_SUPERMARKET_ADDED = "Supermercat agregat exitosament";
    public static final String MESSAGE_OPTION_PRODUCT = """
            Selecciona el tipus de producte:
            1) Alimentari
            2) Cosmètic
            """;
    public static final String INPUT_DATE = "Introdueix la data de caducitat (yyyyMMdd):";
    public static final String INPUT_BRAND = "Introdueix la marca:";
    public static final String MESSAGE_PRODUCT_ADDED = "Producte afegit correctament";
    public static final String MESSAGE_FILES_CREATED = "Supermercats i productes exportats correctament";
    public static final String DATE_FORMAT_INCORRECT = "El format de la data de caducitat no és correcte. Ha de ser " + "yyyyMMdd";
    public static final String ERROR_FILES_EMPTY = "L'arxiu esta buit";
    public static final String MESSAGE_FILES_IMPORTED = "Els arxius han sigut importats correctament";
    public static final String MESSAGE_ASK_NAME = "Introdueixi el nom del supermercat";
    public static final String MESSAGE_ASK_CITY = "A quina ciutat es troba?";
    public static final String MESSAGE_ASK_LONGITUDE = "Introdueixi la longitud on es troba el supermercat";
    public static final String MESSAGE_ASK_LATITUDE = "Introdueixi la latitud on es troba el supermercat";
    public static final String MESSAGE_ASK_PRODUCT_NAME = "Introdueixi el nom del producte";
    public static final String MESSAGE_ASK_PRICE = "Introdueixi el preu del producte";
    public static final String DATE_ERROR = "El format de la data de caducitat no és correcte. Ha de ser " + "yyyyMMdd o es una data pasada" ;
}
