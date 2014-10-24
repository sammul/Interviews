public class MultiplyString {
    public String multiply(String num1, String num2) {
        int l1 = num1.length(), l2=num2.length();
        int l3=l1+l2;
        int[] num = new int[l3];
        int i,j,carry,sum;
        for(i=l1-1; i>=0; i--){
            carry=0;
            for(j=l2-1; j>=0; j--){
                sum = carry+num[i+j+1]+(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                carry = sum/10;
                num[i+j+1] = sum%10;
            }
            num[i+j+1]=carry;
        }
        i=0;
        while(i<l3-1 && num[i]==0)
            i++;
        StringBuilder sb = new StringBuilder();
        while(i<l3)
            sb.append(num[i++]);
        return sb.toString();
    }
}