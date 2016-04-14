//package Sokoban;
//
////import java.util.*;
//
//import games.sokoban.sokoban1.ISokoban;
//
//public class Test {
//    public static void main(String[] args) {
////        Sokoban sokoban = new Sokoban();
////        sokoban.init("#.$@");
////        System.out.println(sokoban.getDynamicCellValue(0, 2));
////
////		System.out.println(Integer.toHexString((0xffc632ff & 0xffffff)));
//
//
//
//
//
//	}
//	private static int log(int block) {
////        int tempVal = 1;
////        int times = 0;
////        while (tempVal <= block) {
////            tempVal *= 2;
////            if (tempVal == block) {
////                return times;
////            }
////            times++;
////        }
////        return -1;
//        for (int t = 1, x = 0; t <= block; t *= 2, x++) {
//            if (t == block) {
//                return x;
//            }
//        }
//        return -1;
//
//
//
//
////        double tempBlock = block;
////        while (tempBlock > 0) {
////            tempBlock = tempBlock/2.;
////            if (tempBlock == 2) {
////                return true;
////            }
////        }
////        return false;
//    }
//
//
//	private static boolean bolle() {
//		System.out.println("bolle");
//		return true;
//	}
//
//
//	private static boolean kake() {
//		System.out.println("kake");
//		return false;
//	}
//
//    private static String cell2key(int value) {
//		switch (value) {
//			case ISokoban.CELL_STATIC_WALL:
//				return "#";
//			case ISokoban.CELL_STATIC_EMPTY 	| ISokoban.CELL_DYNAMIC_EMPTY:
//				return " ";
//			case ISokoban.CELL_STATIC_EMPTY 	| ISokoban.CELL_DYNAMIC_PLAYER:
//				return "@";
//			case ISokoban.CELL_STATIC_EMPTY 	| ISokoban.CELL_DYNAMIC_BOX:
//				return "$";
//			case ISokoban.CELL_STATIC_TARGET 	| ISokoban.CELL_DYNAMIC_EMPTY:
//				return ".";
//			case ISokoban.CELL_STATIC_TARGET 	| ISokoban.CELL_DYNAMIC_PLAYER:
//				return "+";
//			case ISokoban.CELL_STATIC_TARGET 	| ISokoban.CELL_DYNAMIC_BOX:
//				return "*";
//		}
//		return null;
//	}
//}
