// Press ⇧ twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        String str = "We have a large inventory of things in our warehouse falling in "
                + "the category:apperal and the slightly "
                + "more in demand category:makeup along with the category:furniture and ... .";

        printCategories(str);
    }

    public static void printCategories(String str){
        int i = 0;
        boolean categoryExist = false;
        String categories = "";

        while(i < str.length()){
            if(categoryExist){
                if(str.charAt(i) == ' ') {
                    categoryExist = false;
                    categories += " ";
                }
                else
                    categories += str.charAt(i);
                i++;
            }
            else if(!categoryExist){
                int j = str.substring(i).indexOf("category");
                if(j != - 1) {
                    j += i;
                    i = j;
                    categoryExist = true;
                }
                else {
                    i++;
                }
            }
        }

        System.out.println(categories);
    }
}
