import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {
    //比较版本号
    public int compareVersion(String version1, String version2) {
        String[] versionArr1 = version1.split("\\.");
        String[] versionArr2 = version2.split("\\.");
        int len = Math.max(versionArr1.length, versionArr2.length);
        int[] arr1 = new int[len];
        int[] arr2 = new int[len];
        for (int i = 0; i < len; i++) {
            if (i < versionArr1.length) {
                arr1[i] = Integer.valueOf(versionArr1[i]);
            }
            if (i < versionArr2.length) {
                arr2[i] = Integer.valueOf(versionArr2[i]);
            }
            if (arr1[i] > arr2[i]) {
                return 1;
            }
            if (arr1[i] < arr2[i]) {
                return -1;
            }
        }
        return 0;
    }

    //前K个高频单词
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Long> map = Arrays.stream(words).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        ArrayList<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (a, b) -> (int) (map.get(a) == map.get(b) ? a.compareTo(b) : map.get(b) - map.get(a)));
        return list.subList(0, k);
    }

    //同构字符串
    public boolean isIsomorphic(String s, String t) {
        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if(s.indexOf(ch1[i]) != t.indexOf(ch2[i])){
                return false;
            }
        }
        return true;
    }

    //两个数组的交集2
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        //先遍历第一个数组，并初始化map
        for(int i = 0; i < nums1.length; i++) {
            if(map.containsKey(nums1[i]))
                map.put(nums1[i], map.get(nums1[i]) + 1);
            else
                map.put(nums1[i], 1);
        }
        //再遍历第二个数组，将于map中找到的key放入list中
        LinkedList<Integer> list = new LinkedList<Integer>();
        for(int j = 0; j < nums2.length; j++) {
            if(map.containsKey(nums2[j]) && map.get(nums2[j]) > 0) {
                list.add(nums2[j]); //添加到list中
                map.put(nums2[j], map.get(nums2[j]) - 1);
            }
        }
        //最后，将list中的值放入数组中
        int count = list.size();
        int[] aux = new int[count];
        for(int i = 0; i < count; i++) {
            aux[i] = list.poll();
        }
        return aux;
    }

    //两个数组的交集
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        Set<Integer> parentSet = new HashSet<>();
        Set<Integer> childSet = new HashSet<>();
        for (int num : nums1) {
            parentSet.add(num);
        }
        for (int num : nums2) {
            if (parentSet.contains(num)) {
                childSet.add(num);
            }
        }
        int[] resArr = new int[childSet.size()];
        int index = 0;
        for (int value : childSet) {
            resArr[index++] = value;
        }
        return resArr;
    }

    //字符串中第一个唯一字符
    public int firstUniqChar(String s) {
        int[] arr = new int[26];
        for(int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i < s.length(); i++) {
            if(arr[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    //找不同
    public char findTheDifference(String s, String t) {
        int[] record = new int[26];
        int lenS = s.length();
        int lenT = t.length();
        for (int i = 0; i < lenS; i++) {
            record[s.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < lenT; i++) {
            record[t.charAt(i)-'a'] -= 1;
            if (record[t.charAt(i)-'a'] < 0) {
                return t.charAt(i);
            }
        }

        return ' ';
    }
}
