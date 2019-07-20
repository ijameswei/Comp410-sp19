package LinkedList_A1;

class Roman {
    public int romanToInt(String s) {
        int result = 0;
        char[] roman = s.toCharArray();
        int[] values = new int[roman.length];

        for (int i=0; i<roman.length; i++){
            switch (roman[i]){
                case 'I':
                    if(i!= roman.length -1){
                        if(roman[i+1] == 'V' || roman[i+1] == 'X'){
                            values[i] = -1;
                        }else{
                            values[i] = 1;
                        }
                    }else{
                        values[i] = 1;
                    }
                    break;
                case 'V':
                    values[i] = 5;
                    break;
                case 'X':
                    if(i!= roman.length -1){
                        if(roman[i+1] == 'L' || roman[i+1] == 'C'){
                            values[i] = -10;
                        }else{
                            values[i] = 10;
                        }
                    }else{
                        values[i] = 10;
                    }
                    break;
                case 'L':
                    values[i] = 50;
                    break;
                case 'C':
                    if(i!= roman.length -1){
                        if(roman[i+1] == 'D' || roman[i+1] == 'M'){
                            values[i] = -100;
                        }else{
                            values[i] = 100;
                        }
                    }else{
                        values[i] = 100;
                    }
                    break;
                case 'D':
                    values[i] = 500;
                    break;
                default:
                    values[i] = 1000;
                    break;
            }
        }
        for (int i = 0; i<values.length;i++){
            result = result + values[i];
        }
        return result;
    }
}
