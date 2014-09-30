public class NextDigit {

	public static void main(String[] args) {
		System.out.println(NextDigit.next(25431));
		System.out.println(NextDigit.nextRange(25431));
	}

	public static int nextRange(int num) {
		String digit = Integer.toString(num);
		int length = digit.length();
		Integer[] numbers = new Integer[length]; //store each bit
		Integer[] index = { -1, -1 }; //store j and k
		//parse out each bit
		for (int i = length - 1; i >= 0; i--) {
			numbers[i] = num % 10;
			num = num / 10;
		}
		// 1.get j
		for (int i = 0; i < length - 1; i++) {
			if (numbers[i] < numbers[i + 1]) {
				index[0] = i;
			}
		}
		// 2.get k
		for (int i = length - 1; i > index[0] && index[0] >= 0; i--) {
			if (numbers[i] > numbers[index[0]]) {
				index[1] = i;
				break;
			}
		}
		// 3.exchange numbers[j] and numbers[k]
		if (index[0] >= 0 && index[1] >= 0) {
			int tempNumber = numbers[index[0]];
			numbers[index[0]] = numbers[index[1]];
			numbers[index[1]] = tempNumber;
		}
		// 4.reverse numbers[j+1...n]
		for (int i = index[0] + 1, j = length - 1; i < j; i++, j--) {
			int temp = numbers[i];
			numbers[i] = numbers[j];
			numbers[j] = temp;
		}
		int result = 0;
		for (int i = 0; i < length; i++) {
			result = result * 10 + numbers[i];
		}
		return result;
	}

	public static int next(int num) {
		int[] digit = new int[20];
		int n = num, len = 0;
		int[] min = new int[20];
		for (int i = 0; i < 20; i++) {
			min[i] = 10;
		}
		while (n != 0) {
			digit[len++] = n % 10;
			n = n / 10;
		}
		//
		for (int i = 1; i < len; i++) {
			int m = 0;
			for (int j = 0; j < i; j++) {
				if (digit[j] > digit[i]) {
					min[j] = digit[j];
					m++;
				}
			}
			if (m > 0) {
				int mini = min[0];
				int pos = 0;
				for (int j = 0; j < i; j++) {
					if (min[j] < mini) {
						mini = min[j];
						pos = j;
					}
				}
				int temp = digit[i];
				digit[i] = digit[pos];
				digit[pos] = temp;
				for (int k = 0; k < i - 1; k++) {
					for (int s = k + 1; s < i; s++) {
						if (digit[k] < digit[s]) {
							temp = digit[k];
							digit[k] = digit[s];
							digit[s] = temp;
						}
					}
				}
				break;
			}
		}
		int sum = 0;
		for (int i = 0, j = 1; i < len; i++, j = j * 10) {
			sum += digit[i] * j;
		}
		return sum;
	}
}
