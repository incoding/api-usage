package com.javaapi.test.test.testType.String.testString.toolString;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Test;



public class TestBiz {
//	public static void main(String[] args) throws Exception {
//		String aa = FileTools.getFileContent(new File(
//				"C:\\Users\\Administrator\\Desktop\\fudongkuang.txt"), "UTF-8");
//		BufferedReader is=new BufferedReader (new InputStreamReader(new FileInputStream(new File("C:\\Users\\Administrator\\Desktop\\fudongkuang.txt"))));
//		String temp ;
//		JSONObject joJsonObject=new JSONObject();
//		Map<String, String> map=new HashMap<String, String>();
//		String [] strArray =new String[200];
//		String aString="";
//		int length=0;
//		while ((temp = is.readLine())  != null) {
//			if(StringUtils.isNotBlank(temp)){
////				String type= temp.split("=>")[0];
////				String number =	temp.split("=>")[1];
////				map.put(number, type);
////				type = type.substring(type.indexOf("\'")+1,type.lastIndexOf("\'"));
////				number = number.substring(number.indexOf("\'")+1,number.lastIndexOf("\'"));
//////				System.out.println(type+"----"+number);
//////				map.put(number, type);
//////				joJsonObject.put(number, type);
////				joJsonObject.put(type, number);
////				strArray[length++]="\'"+type+"\'";
//				aString+=temp.trim();
//			}
//		}
//		System.out.println(aString);
////		System.out.println(Arrays.toString(strArray));
////		System.out.println(JSON.toJSON(aa).toString());
////		JSON.toJSON(map).toString();
////		JSON.toJSONString(map, SerializerFeature.UseSingleQuotes);
////		System.out.println(JSON.toJSONString(map));
////		System.out.println(JSON.toJSONString(joJsonObject, SerializerFeature.UseSingleQuotes));
//	}

    @Test
    public void testFile() throws IOException, InterruptedException {
        long tempRunCount = 1200;
        long tempSleep = 200;
        String path = "/mfs/ShareFile/news/0/33/10001/test-ssi-sinanba.shtml";
        File pathFile = new File(path);
        String tmpPath = path + ".tmp";
        File tmp = new File(tmpPath);
        for (long i = 0; i < tempRunCount; i++) {
            FileOutputStream fos = new FileOutputStream(tmp, false);
            fos.write(new String(new Date().getTime() + "aaaaa" + i).getBytes());
            fos.close();
            if (tmp != null) {
                if (!tmp.renameTo(pathFile)) {
                    //we may want to retry if move fails
                    tmp.delete();
                    FileOutputStream ff = new FileOutputStream(pathFile, false);
                    ff.write(new String(new Date().getTime() + "aaaaa" + i).getBytes());
                    ff.close();
                }
            }

            Thread.sleep(tempSleep);
        }

    }
  
    @Test
    public void parseFixedForbiddenLotteryTypes() {
        String specialHint = "未开玩法:全场比分,让球胜平负";
        List<String> forbiddenLotteryTypeList = new ArrayList<String>();

        if (specialHint == null || specialHint.trim().length() < 1) {
            return;
        }
        if (specialHint.trim().contains("未开")) {
            specialHint = specialHint.trim().replaceAll("未开.*:", "").trim();
            specialHint = specialHint.replaceAll("让球胜平负", "4051").replaceAll("上下单双", "4052").replaceAll("总进球数", "4053")
                    .replaceAll("全场比分", "4054").replaceAll("半全场", "4055");
            forbiddenLotteryTypeList.addAll( Arrays.asList(specialHint.split(",")));
        }
        System.out.println(forbiddenLotteryTypeList);
    }

}