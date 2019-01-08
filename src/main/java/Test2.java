public class Test2 {

    public static int digitAtIndex(int index){
        if(index<0)
            return -1;
        if(index<10)
            return index;
        int curIndex = 10,length = 2;
        int boundNum = 10;
        while (curIndex+lengthSum(length)<index){//若index=190，进入3位数100的1位
            curIndex+=lengthSum(length);
            boundNum*=10;
            length++;
        }
        int addNum = (index-curIndex)/length;//180/2=90
        int curNum = boundNum + addNum;//90+10=100
        return Integer.toString(curNum).charAt(index-curIndex-addNum*length)-'0';
    }

    public static int lengthSum(int length){
        int count = 9;
        for(int i=1;i<length;i++)
            count*=10;
        return count*length;
    }

    public static void main(String[] args){
//        for(int i=9;i<16;i++)
//            System.out.println(digitAtIndex(i));
//        System.out.println(digitAtIndex(1001));

        System.out.println("23");
    }
}

