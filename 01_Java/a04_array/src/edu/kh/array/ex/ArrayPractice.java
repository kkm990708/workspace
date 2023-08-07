package edu.kh.array.ex;

import java.util.Scanner;

import javax.management.MXBean;

public class ArrayPractice {
	private Scanner sc = new Scanner(System.in);
	public void practice1() {
		int sum = 0;
		int[] arr = new int[9];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i+1;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
			if (i % 2 == 0) {
				sum += arr[i];
			}
		}
		System.out.printf("\n짝수 번째 인덱스 합 : %d",sum);
	}
	
	public void practice2() {
		int sum = 0;
		int[] arr = new int[9];
		
		for (int i = arr.length - 1; i >= 0 ; i--) {
			arr[i] = i+1;
		}
		for (int i = arr.length - 1; i >= 0 ; i--) {
			System.out.print(arr[i] + " ");
			if (i % 2 == 1) {
				sum += arr[i];
			}
		}
		System.out.printf("\n홀수 번째 인덱스 합 : %d",sum);
	}
	
	public void practice3() {
		
		System.out.print("양의 정수 : ");
		int input = sc.nextInt();
		int[] num = new int[input];
		for (int i = 0; i < num.length; i++) {
			num[i] = i + 1;
		}
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}
	}
	
	public void practice4() {
		int[] arr = new int[5];
		int input = 0;
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("입력 %d : ", i);
			arr[i] = sc.nextInt();
		}
		
		System.out.print("검색할 값 : ");
		input = sc.nextInt();
		boolean check = true;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == input) {
				System.out.printf("인덱스 : %d", i);
				check = false;
			}
		}
		if (check) {
			System.out.println("일치하는 값이 존재하지 않습니다");
		}
	}
	
	public void practice5() {
		System.out.print("문자열 : ");
		String str = sc.next();
		System.out.print("문자 : ");
		char ch = sc.next().charAt(0);
		int count = 0;
		
		char[] chArray = new char[str.length()];
		for (int i = 0; i < str.length(); i++) {
			chArray[i] = str.charAt(i);
		}
		
		System.out.printf("%s에 %c가 존재하는 위치(인덱스) : ",str,ch);
		for (int i = 0; i < chArray.length; i++) {
			if (chArray[i] == ch) {
				System.out.print(i + " ");
				count++;
			}
		}
		System.out.println("\ni의 개수 : " + count);
	}
	
	public void practice6() {
		
		System.out.print("정수 : ");
		int input = sc.nextInt();
		int sum = 0;
		int[] arr = new int[input];
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("배열 %d번째 인덱스에 넣을 값 : ", i);
			arr[i] = sc.nextInt();
		}
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
			sum += arr[i];
		}
		System.out.println("\n총 합 : " + sum);
	}
	
	public void practice7() {
		System.out.print("주민등록번호(-포함) : ");
		String str = sc.next();
		char[] arr = new char[str.length()];
		for (int i = 0; i < arr.length; i++) {
			if (i >= 8) {
				arr[i] = '*';
				continue;
			}
			arr[i] = str.charAt(i);
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
	}
	
	public void practice8() {

		while (true) {
			System.out.print("정수 : ");
			int input = sc.nextInt();
			if (input % 2 == 0 || input < 3) {
				System.out.println("다시 입력하세요");
			}
			else {
				for (int i = 0; i < input/2 + 1; i++) {
					System.out.print((i + 1) + " ");
				}
				for (int i = input/2 ; i >= 1 ; i--) {
					System.out.print(i + " ");
				}
				break;
			}
		}
	}
	
	public void practice9() {
		int[] arr= new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 10 + 1);
		}
		System.out.print("발생한 난수 : ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	public void practice10() {
		int[] arr= new int[10];
		int max = 0;
		int min = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 10 + 1);
		}
		max = arr[0];
		min = arr[0];
		System.out.print("발생한 난수 : ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
			if (arr[i] > max) {
				max = arr[i];
			}
			if (arr[i] < min) {
				min = arr[i];
			}
		}
		System.out.println("\n최대값 : " + max);
		System.out.println("최소값 : " + min);
	}
	
	public void practice11() {
		int[] arr= new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 10 + 1);
			
			for (int j = 0; j < i; j++) {
				if (arr[j] == arr [i]) {
					i--;
					break;
				}
			}
		}
		System.out.print("발생한 난수 : ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	
	public void practice12() {
		int[] arr = new int[6];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 99 + 1);
			for (int j = 0; j < i; j++) {
				if (arr[j] == arr [i]) {
					i--;
					break;
				}
			}
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}
	
	public void practice13() {
		System.out.print("문자열 : ");
		String str = sc.next();
		int count = 0;
		boolean check = false;
		char[] chArray = new char[str.length()];
		int arrayLength = str.length();
		
		for (int i = 0; i < arrayLength; i++) {
			char temp = str.charAt(i);
			
			for (int j = 0; j < chArray.length; j++) {
				if (temp == chArray[j]) {
					check = true;
				}
			}
			
			if (check) {
				check = false;
				continue;
			}
			chArray[i] = temp;
			count++;
		}
		System.out.print("문자열에 있는 문자 : ");
		for (int i = 0; i < chArray.length; i++) {
			if (chArray[i] == 0) {
				continue;
			}
			System.out.print(chArray[i] + ", ");
		}
		System.out.println("\ni의 개수 : " + count);
	}
	
	
	public void practice14() {
		System.out.print("배열의 크기를 입력하세요 : ");
		String[] arr = new String[sc.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("%d번째 배열의 값을 입력하세요 : ", i);
			arr[i] = sc.next();
		}
		while (true) {
			System.out.print("배열의 값을 추가로 입력하겠습니까?(1.예/0.아니오) : ");
			int select = sc.nextInt();
			if (select == 1) {
				System.out.print("추가로 입력할 배열의 길이를 입력하세요 : ");
				int lengthPlus = sc.nextInt();
				String[] temp = arr;
				arr = new String[arr.length+lengthPlus];
				for (int i = 0; i < temp.length; i++) {
					arr[i] = temp[i];
				}
				for (int i = temp.length; i < arr.length; i++) {
					System.out.printf("%d번째 배열의 값을 입력하세요 : ", i);
					arr[i] = sc.next();
				}
				continue;
			}
			if (select == 0) {
				break;
			}
			System.out.println("1 또는 0 을 입력해 주세요");
		}
		
		System.out.print("[");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			if (i < arr.length-1) {
				System.out.print(", ");
			}
		}
		System.out.print("]");
	}
    public void practice15(){
        String[][] arr = new String[3][3];

        for (int i = 0 ; i < arr.length ; i++){
            for (int j = 0 ; j < arr[i].length ; j++){
                arr[i][j] = "("+i+","+j+")";
            }
            System.out.println();
        }

        for (int i = 0 ; i < arr.length ; i++){
            for (int j = 0 ; j < arr[i].length ; j++){
                System.out.printf(arr[i][j]);
            }
            System.out.println();
        }
    }


    public void practice16(){
        int[][] arr = new int[4][4];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = (i*4) + j + 1;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("%3d",arr[i][j]);
            }
            System.out.println();
        }
    }

    public void practice17(){
        int count = 16;
        int[][] arr = new int[4][4];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = count--;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("%3d",arr[i][j]);
            }
            System.out.println();
        }
    }

    public void practice18(){
        int[][] arr = new int[4][4];
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr[i].length-1; j++) {
                arr[i][j] = (int)(Math.random() * 10 + 1);
                arr[i][3] += arr[i][j];
                arr[3][j] += arr[i][j];
                arr[3][3] += arr[i][j];
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("%3d",arr[i][j]);
            }
            System.out.println();
        }
    }
    public void practice19(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("행 크기 : ");
        int row = scanner.nextInt();
        System.out.print("열 크기 : ");
        int col = scanner.nextInt();
        int[][] arr = new int[row][col];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = (int)(Math.random() * 26 + 65);
            }
        }
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("%c ",(char)(arr[i][j]));
            }
            System.out.println();
        }
    }

    public void practice20(){
        Scanner scanner = new Scanner(System.in);
        char ch = 'a';
        System.out.print("행 크기 : ");
        int row = scanner.nextInt();
        char[][] arr = new char[row][];
        for (int i = 0; i < row; i++) {
            System.out.printf("%d열의 크기 : ",i);
            arr[i] = new char[scanner.nextInt()];
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = ch++;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void practice21(){
        String[] students = {"강건강", "남나나", "도대담", "류라라", "문미미", "박보배",
                "송성실", "윤예의", "진재주", "차천축", "피풍표", "홍하하"};
        int count = 0;
        String[][] arr = new String[3][2];
        String[][] arr2 = new String[3][2];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = students[count++];
            }
        }

        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[i].length; j++) {
                arr2[i][j] = students[count++];
            }
        }

        System.out.println("=== 1분단 ===");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "   ");
            }
            System.out.println();
        }

        System.out.println("=== 2분단 ===");
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[i].length; j++) {
                System.out.print(arr2[i][j] + "   ");
            }
            System.out.println();
        }
    }

    public void practice22(){
        Scanner scanner =new Scanner(System.in);
        String[] students = {"강건강", "남나나", "도대담", "류라라", "문미미", "박보배",
                "송성실", "윤예의", "진재주", "차천축", "피풍표", "홍하하"};
        int count = 0;
        String[][] arr = new String[3][2];
        String[][] arr2 = new String[3][2];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = students[count++];
            }
        }

        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[i].length; j++) {
                arr2[i][j] = students[count++];
            }
        }

        System.out.println("=== 1분단 ===");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "   ");
            }
            System.out.println();
        }

        System.out.println("=== 2분단 ===");
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[i].length; j++) {
                System.out.print(arr2[i][j] + "   ");
            }
            System.out.println();
        }
        System.out.println("=================================");
        System.out.print("검색할 학생 이름을 입력하세요 : ");
        String input = scanner.next();
        String rightLetf = "";

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (input.equals(arr[i][j])){
                    if (j==0){
                        rightLetf = "왼쪽";
                    }
                    if (j==1){
                        rightLetf = "오른쪽";
                    }
                    System.out.printf("검색하신 %s 학생은 1분단 %d번째 줄 %s에 있습니다\n",input,i+1,rightLetf);
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (input.equals(arr2[i][j])){
                    if (j==0){
                        rightLetf = "왼쪽";
                    }
                    if (j==1){
                        rightLetf = "오른쪽";
                    }
                    System.out.printf("검색하신 %s 학생은 2분단 %d번째 줄 %s에 있습니다",input,i+1,rightLetf);
                }
            }
        }
    }

    public void practice23(){
        Scanner scanner = new Scanner(System.in);
        String[][] arr = new String[6][6];
        arr[0][0] = "  ";
        System.out.print("행 인덱스 입력 : ");
        int row = scanner.nextInt() + 1;
        System.out.print("열 인덱스 입력 : ");
        int col = scanner.nextInt() + 1;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[i].length; j++) {
                arr[i][j] = "  ";
                arr[0][i] = String.format("%d ",i - 1);
                arr[j][0] = String.format("%d ",j - 1);
            }
        }
        arr[row][col] = "X ";
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

    public void practice24(){
        Scanner scanner = new Scanner(System.in);
        String[][] arr = new String[6][6];
        arr[0][0] = "  ";
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[i].length; j++) {
                arr[i][j] = "  ";
                arr[0][i] = String.format("%d ", i - 1);
                arr[j][0] = String.format("%d ", j - 1);
            }
        }
        while (true) {

            System.out.print("행 인덱스 입력 : ");
            int row = scanner.nextInt() + 1;
            if (row == 100){
                System.out.println("프로그램 종료");
                break;
            }
            System.out.print("열 인덱스 입력 : ");
            int col = scanner.nextInt() + 1;

            arr[row][col] = "X ";
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    System.out.print(arr[i][j]);
                }
                System.out.println();
            }
            System.out.println();
        }
    }
    			
    public void BingoGame(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("빙고판 크기 지정 : ");
        int size = scanner.nextInt();
        int count = 0;
        
        int[] check = new int[size*size];
        int[][] bingArr = new int[size][size];
        for (int i = 0; i < bingArr.length; i++) {
            for (int j = 0; j < bingArr[i].length; j++) {
            	
                bingArr[i][j] = (int)(Math.random() * size * size + 1);
                check[count++] = bingArr[i][j];
                
                for (int j2 = 0; j2 < check.length; j2++) {
					if (bingArr[i][j] == check[j2]) {
						j--;
						count--;
						break;
					}
				}
            }
        }
        for (int i = 0; i < bingArr.length; i++) {
			for (int j = 0; j < bingArr.length; j++) {
				System.out.printf("%3d", bingArr[i][j]);
			}
		}
        System.out.println("======== 빙고 게임 시작 ========");
        while (true) {
        	System.out.print("정수를 입력하시오 : ");
        	int input = scanner.nextInt();
            for (int i = 0; i < bingArr.length; i++) {
    			for (int j = 0; j < bingArr.length; j++) {
    				if (bingArr[i][j] == input) {
						bingArr[i][j] = 0;
					}
    			}
    		}
            
            for (int i = 0; i < bingArr.length; i++) {
    			for (int j = 0; j < bingArr.length; j++) {
    				if (bingArr[i][j] == 0) {
						System.out.print("  ★");
					}
    				System.out.printf("%3d", bingArr[i][j]);
    			}
    		}
            
		}
    }
}
