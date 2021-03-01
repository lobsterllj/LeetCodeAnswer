public class main {
    public static void main(String[] args) {
        RandomizedCollection obj = new RandomizedCollection();
        boolean param_1 = obj.insert(4);
        System.out.println("1i:"+obj.show());
        boolean param_2 = obj.insert(3);
        System.out.println("2i:"+obj.show());
        boolean param_3 = obj.insert(4);
        System.out.println("3i:"+obj.show());
        boolean param_4 = obj.insert(2);
        System.out.println("4i:"+obj.show());
        boolean param_5 = obj.insert(4);
        System.out.println("5i:"+obj.show());
        boolean param_6 = obj.remove(4);
        System.out.println("6r:"+obj.show());
        boolean param_7 = obj.remove(3);
        System.out.println("7r:"+obj.show());
        boolean param_8 = obj.remove(4);
        System.out.println("8r:"+obj.show());
        System.out.println("-------");
        boolean param_9 = obj.remove(4);
        System.out.println("9r:"+obj.show());
//        boolean param_3 = obj.insert(-2);
//        System.out.println(obj.show());
//        int param_4 = obj.getRandom();
//        System.out.println(obj.show());
//        boolean param_5 = obj.remove(-1);
//        System.out.println(obj.show());
//        boolean param_6 = obj.remove(-2);
//        System.out.println(obj.show());
//        int param_7 = obj.getRandom();
//        System.out.println(obj.show());

    }
}
