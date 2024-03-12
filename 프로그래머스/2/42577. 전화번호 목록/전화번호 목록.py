def solution(phone_books):
    # 문자순대로 정렬
    phone_books.sort()
    # 전화번호부 전체 길이
    l = len(phone_books)
    # 인덱스 형태로 반복문 실행
    for i in range(l-1):
        # 체크할 두 번호 확인
        check_phone1 = phone_books[i]
        check_phone2 = phone_books[i+1]
        # 체크할 번호 길이 확인, 길이 확인되었다면 접두사 같은 지 확인
        if len(check_phone1) <= len(check_phone2) and check_phone1 == check_phone2[:len(check_phone1)]:
            return False
    return True