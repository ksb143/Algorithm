TC = int(input())  # 테스트 케이스 수

for tc in range(TC):
    N = int(input())  # 지원자 수
    applicants = []  # 지원자 리스트
    for n in range(N):
        # 서류 심사 성적, 면접 성적
        document, interview = map(int, input().split())
        applicants.append((document, interview))
    applicants.sort()  # 서류 심사 성적따라 정렬
    # 첫 번재 서류 1등은 바로 통과니까 삽입
    pass_document, pass_interview = applicants.pop(0)
    cnt = 1
    for d, i in applicants:
         # 서류통과자보다 면접 순위 높으면
         if pass_interview > i:
             # 인원수 늘리기
             cnt += 1
             # 면접 순위도 바꾸기
             pass_interview = i
    print(cnt)
