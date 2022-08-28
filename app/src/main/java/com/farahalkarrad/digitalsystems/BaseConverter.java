package com.farahalkarrad.digitalsystems;

public class BaseConverter {
    private final String sourceBase, desBase, number;


    public BaseConverter(String sourceBase, String desBase, String number){
        this.sourceBase = sourceBase;
        this.desBase = desBase;
        this.number = number;
    }

    public String getResult(){
        // In case empty input
        if(this.number.equals("")){
            return "";
        }
        else{
            if(this.sourceBase.equals("DEC")) {
                // In case input does not match decimal system constraints
                for (int i = 0; i < number.length(); i++) {
                    if (number.charAt(i) != '0' && number.charAt(i) != '1' && number.charAt(i) != '2' &&
                            number.charAt(i) != '3' && number.charAt(i) != '4' && number.charAt(i) != '5' &&
                            number.charAt(i) != '6' && number.charAt(i) != '7' && number.charAt(i) != '8' &&
                            number.charAt(i) != '9') {
                        return "Can't convert this number.\nPlease enter digits from 0-to 9 only.";
                    }
                }

                if (this.desBase.equals("DEC")) {
                    return this.number;
                } else if (this.desBase.equals("BIN")) {
                    return Long.toBinaryString(Long.parseLong(this.number));
                } else if (this.desBase.equals("OCT")){
                    return Long.toOctalString(Long.parseLong(this.number));
                } else if (this.desBase.equals("HEX")) {
                    return Long.toHexString(Long.parseLong(this.number));
                }
            }
            else if(this.sourceBase.equals("BIN")){
                // In case input does not match binary system constraints
                for(int i=0;i<number.length();i++) {
                    if (number.charAt(i) != '0' && number.charAt(i) != '1') {
                        return "Can't convert this number.\nPlease enter 0's and 1's digits only.";
                    }
                }
                if (this.desBase.equals("DEC")) {
                    return String.valueOf(Long.parseLong(this.number,2));
                } else if (this.desBase.equals("BIN")) {
                    return this.number;
                } else if (this.desBase.equals("OCT")) {
                    return Long.toOctalString(Long.parseLong(String.valueOf(Long.parseLong(this.number,2))));
                } else if (this.desBase.equals("HEX")) {
                    return Long.toHexString(Long.parseLong(String.valueOf(Long.parseLong(this.number,2))));
                }
            }
            else if(this.sourceBase.equals("OCT")){
                // In case input does not match octal system constraints
                for(int i=0;i<number.length();i++){
                    if(number.charAt(i) != '0' && number.charAt(i) != '1' && number.charAt(i) != '2' &&
                            number.charAt(i) != '3' && number.charAt(i) != '4' && number.charAt(i) != '5' &&
                            number.charAt(i) != '6' && number.charAt(i) != '7'){
                        return "Can't convert this number. \nPlease enter digits from 0-to 7 only.";
                    }
                }
                if (this.desBase.equals("DEC")) {
                    return String.valueOf(Long.parseLong(this.number,8));
                } else if (this.desBase.equals("BIN")) {
                    return Long.toBinaryString(Long.parseLong(String.valueOf(Long.parseLong(this.number,8))));
                } else if (this.desBase.equals("OCT")) {
                    return this.number;
                } else if (this.desBase.equals("HEX")) {
                    return Long.toHexString(Long.parseLong(String.valueOf(Long.parseLong(this.number,8))));
                }
            }
            else if(this.sourceBase.equals("HEX")){
                // In case input does not match hexa-decimal system constraints
                for(int i=0;i<number.length();i++){
                    if(number.charAt(i) != '0' && number.charAt(i) != '1' && number.charAt(i) != '2' &&
                            number.charAt(i) != '3' && number.charAt(i) != '4' && number.charAt(i) != '5' &&
                            number.charAt(i) != '6' && number.charAt(i) != '7' && number.charAt(i) != '8' &&
                            number.charAt(i) != '9' && number.charAt(i) != 'A' && number.charAt(i) != 'a' &&
                            number.charAt(i) != 'B' && number.charAt(i) != 'b' && number.charAt(i) != 'C' &&
                            number.charAt(i) != 'c' && number.charAt(i) != 'D' && number.charAt(i) != 'd' &&
                            number.charAt(i) != 'E' && number.charAt(i) != 'e' && number.charAt(i) != 'F' &&
                            number.charAt(i) != 'f'){
                        return "Can't convert this number. \nPlease enter digits from 0-to 9 and from a-to f only.";
                    }
                }
                if (this.desBase.equals("DEC")) {
                    return String.valueOf(Long.parseLong(this.number,16));
                } else if (this.desBase.equals("BIN")) {
                    return Long.toBinaryString(Long.parseLong(String.valueOf(Long.parseLong(this.number,16))));
                } else if (this.desBase.equals("OCT")) {
                    return Long.toOctalString(Long.parseLong(String.valueOf(Long.parseLong(this.number,16))));
                } else if (this.desBase.equals("HEX")) {
                    return this.number;
                }
            }
        }
        return "Can't convert this number";
    }
}
