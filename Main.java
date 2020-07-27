package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println(GridManager.getCellGreenStates());
    }
}

/*
--Sample input Example 01--
3, 3
000
111
000
1, 0, 10
--Expected result: 5 --

--Sample input Example 02--
4, 4
1001
1111
0100
1010
2, 2, 15
--Expected result: 14 --

--Sample input Example 03--
1, 1
1
0, 0, 2

--Sample input Example 04--
2, 2
11
01
0, 1, 3

--Sample input Example 05--
4, 4
0110
0110
0110
0110
1, 3, 5

--Sample input Example 06--
3, 3
110
010
001
1, 1, 7

--Sample input Example 07--
5, 5
00000
00000
11111
00000
00000
1, 2, 1000000000
 */