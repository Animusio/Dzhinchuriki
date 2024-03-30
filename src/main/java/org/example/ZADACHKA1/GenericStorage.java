package org.example.ZADACHKA1;



//ЗАДАНИЕ 1
//Переделайте обычный класс хранилище в обобщенный класс чтобы он смог принимать не только строки


//public class GenericStorage {
//    private String item;
//
//    public void addItem(String item) {
//        this.item = item;
//    }
//
//    public String getItem() {
//        return item;
//    }
//    @Override
//    public String toString() {
//        return "Storage{" +
//                "item=" + item +
//                '}';
//    }
//}









//Решение -

//public class GenericStorage<P> {
//    private P item;
//    private void addItem(P item) {
//        this.item = item;
//    }
//    private P getItem() {
//        return item;
//    }
//    @Override
//    public String toString() {
//        return "Storage{" +
//                "item=" + item +
//                '}';
//    }
//}

