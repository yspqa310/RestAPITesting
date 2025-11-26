package Practice.LibraryAPI;

public class AddLibraryPayLoad {

    public static String AddBook(String bookName,String authorName,String isbn,String aisle){
        return "{\n" +
                "\"name\":\""+bookName+"\",\n" +
                "\"isbn\":\""+isbn+"\",\n" +
                "\"aisle\":\""+aisle+"\",\n" +
                "\"author\":\""+authorName+"\"\n" +
                "}\n" +
                " \n";
    }
}
