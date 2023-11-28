def solution(today, terms, privacies):
    answer = []
    term = {}
    today = int(today.replace(".",""))
    for i in terms:
        a,b = i.split(" ")
        term[a] = int(b)
        
    for i in range(len(privacies)):
        date, num = privacies[i].split(" ")
        year,month,day = map(int,date.split("."))
        value = term[num]
        month += value
        day -= 1
        if day == 0:
            day = 28
            month -= 1
        while month > 12:
            month -= 12
            year += 1
            
        result = int(change_str(year)+change_str(month)+change_str(day))
        if today > result:
            answer.append(i+1)
        
    return answer


def change_str(value):
    if value < 10:
        return "0%d"%value
    else:
        return "%d"%value
        