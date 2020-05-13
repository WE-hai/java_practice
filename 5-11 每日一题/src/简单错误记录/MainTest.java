package 简单错误记录;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class MainTest {
    static class EFile{
        public String name;
        public int line;
        public int num;
        public int order;

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + line;
            result = prime * result + ((name == null) ? 0 : name.hashCode());
            return result;
        }
        @Override
        public boolean equals(Object obj) {

            EFile other = (EFile) obj;
            if (this == obj){
                other.num++; return true;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            if (line != other.line){
                return false;
            }
            if (name == null) {
                if (other.name != null) {
                    return false;
                }
            } else if (!name.equals(other.name)){
                return false;
            }
            other.num++;
            return true;
        }

    }
    public static void main(String[] args){
        Set<EFile> set = new HashSet<EFile>();
        Scanner in = new Scanner(System.in);
        int j = 0;
        while (in.hasNext()) {
            String s = in.next();
            int line = in.nextInt();
            EFile file = new EFile();
            int bi = s.lastIndexOf("\\");
            file.name = s.substring(bi+1);
            file.line = line;
            if(set.add(file)){
                file.num++;
                file.order = j;
                j++;
            }
        }
        in.close();
        List<EFile> list = new ArrayList<EFile> (set);
        Comparator<EFile> cmp = new Comparator<EFile>() {
            @Override
            public int compare(EFile o1, EFile o2) {
                return o1.num - o2.num ==0 ?(o1.order-o2.order):(o2.num-o1.num);
            }
        };
        Collections.sort(list,cmp);
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < (list.size() > 8 ? 8 : list.size()); i ++){
            StringBuffer result;
            EFile eFile = list.get(i);
            if(eFile.name.length() > 16){
                result =new StringBuffer(eFile.name.substring(eFile.name.length() - 16, eFile.name.length()));
            }else{
                result =new StringBuffer(eFile.name);
            }
            result.append(" ").append(eFile.line).append(" ").append(eFile.num);
            System.out.println(result.toString());
        }
    }
}