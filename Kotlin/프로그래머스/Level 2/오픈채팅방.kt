class Solution {
    fun solution(record: Array<String>): Array<String> {
        
        var idMap = mutableMapOf<String, String>()
        var result = ArrayList<Pair<String, String>>()
        
        for(dat in record){
            var dats = dat.split(" ")
            if(dats.size > 2){
                var (state, id, nickname) = dats
                if(state == "Enter"){
                    idMap.put(id, nickname)
                    result.add(Pair(id, "님이 들어왔습니다."))
                    }
                 else{
                    idMap.put(id, nickname)
                }
            }
            else{
                var(state, id) = dats
                result.add(Pair(id, "님이 나갔습니다."))
            }
            
        }
        
        var answer = Array<String>(result.size){it->""}
        
        for(i in 0 until result.size){
            answer[i] = idMap.getOrDefault(result[i].first, "")+result[i].second
        }
        return answer
    }
}