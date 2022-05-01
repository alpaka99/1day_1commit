// 한번에 한명의 유저를 신고
// 신고횟수에 제한 x
// 동일 유저에 대한 신고 횟수는 1회로 처리
// k 번 이상 신고된 유저는 게시판 이용이 정지 -> 해당 유저를 신고한 모든 유저에게 정지 사실을 메일로 발송

class Solution {
    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
        var answer: IntArray = IntArray(id_list.size)
        
        var reportMap = mutableMapOf<String, MutableSet<String>>() // 내가 누굴 신고했나 보는 맵
        var reportCountMap = mutableMapOf<String, MutableSet<String>>() // 내가 몇번 신고당했나 확인하는 맵
        
        id_list.forEach{ // 맵들 초기화
            reportMap.put(it, mutableSetOf<String>()) // "신고자": [신고한 사람들]
            reportCountMap.put(it, mutableSetOf<String>()) // "신고당한 사람" : [날 신고한 사람들]
        }
        
        
        report.forEach{ // 신고하는 로직
            var(reporter, reported) = it.split(" ")
            
            // 신고자 : [내가 신고한 사람들]
            if(reportMap.containsKey(reporter)){
                reportMap[reporter]!!.add(reported)
            }
            
            // 신고 당한 사람 : [날 신고한 사람들]
            if(reportCountMap.containsKey(reported)){
                reportCountMap[reported]!!.add(reporter)
            }
            
        }
        
        // 정지 당한 사람을 찾음
        var banned = mutableSetOf<String>()
        
        reportCountMap.keys.forEach{
            if(reportCountMap[it]!!.size >= k) {
                banned.add(it)
            }
        }
        
        // 각 아이디가 신고한 사람이 정지 당했나 안당했나 판단
        for(i in 0 until id_list.size) {
            var reportList = reportMap[id_list[i]]
            
            reportList!!.forEach{
                if(banned.contains(it)){
                    answer[i]++
                }
            }
        }
        
        
        return answer
    }
}