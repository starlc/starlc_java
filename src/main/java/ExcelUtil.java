import com.starlc.util.Console;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import javax.sound.midi.Soundbank;

public class ExcelUtil {
    public static void main(String[] args) {
        exportHearder();
        exportContext();
    }

    private static void exportHearder() {
        String strHeader="总分\t客观题\t主观题\t第2题\t第3题\t第4题\t第5题\t第6题\t第7题\t第9题\t第10题\t第13题\t第14题\t第17题\t第18题\t第20题\t第21题\t第24题\t第书写作文题\t"
                + "第书写作文-1题\t第书写作文-2题\t第三（7）题\t第8题\t第11题\t第12题\t第15题\t第16题\t第19题\t第22题\t第23题\t第25题";
        String[]arr = strHeader.split("\t");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+"\t"+arr[i]+"%\t");
        }
        System.out.println("");
    }


    static void exportContext(){
        String[] arr = new String[]{"F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","AA","AB","AC","AD","AE","AF","AG","AH","AI","AJ"};
        int[] startNode = new int[]{3,40,78,114,152,189,225,263,299,337,374,410,446};
        String formula = "=AVERAGE({0}start:{1}end)\t"+"=AVERAGE({0}start:{1}end)/MAX({0}3:{1}445)*100\t";
        List<String> lstFormat = new ArrayList<>();
        for (int i = 0; i < startNode.length; i++) {
            if (i==startNode.length-1)break;
            lstFormat.add(formula.replace("start",startNode[i]+"").replace("end",startNode[i+1]-1+""));
        }
        lstFormat.add(formula.replace("start",startNode[0]+"").replace("end",startNode[startNode.length-1]-1+""));

        String[] formatARR = lstFormat.toArray(new String[]{});
        //formatARR = new String[]{"=AVERAGE({0}3:{1}39)","=AVERAGE({0}40:{1}77)","=AVERAGE({0}78:{1}113)","=AVERAGE({0}114:{1}151)","=AVERAGE({0}152:{1}188)","=AVERAGE({0}189:{1}224)",
        //      "=AVERAGE({0}225:{1}261)","=AVERAGE({0}262:{1}298)","=AVERAGE({0}299:{1}336)","=AVERAGE({0}337:{1}373)","=AVERAGE({0}374:{1}409)","=AVERAGE({0}410:{1}445)","=AVERAGE({0}3:{1}445)"};
        for (int j = 0; j <formatARR.length ; j++) {
            for (int i = 0; i <arr.length ; i++) {
                System.out.print(MessageFormat.format(formatARR[j],arr[i],arr[i]));
            }
            System.out.println("");
        }
    }
}
