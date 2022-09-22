public class Test_Only {
    public static void main(String[] args){
        String str = String.format("%1$" + 4 + "s", "1010101010").replace(' ', '-');
        str = "01";
        str = str.substring(str.length()-4);
        System.out.println(str);
    }
}
