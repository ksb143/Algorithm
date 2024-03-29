T = int(input())

for tc in range(T):
    N, M = map(int, input().split())
    # 팩토리얼을 넣을 리스트 만들기
    mp = [0] * (M+1)
    mp[0] = 1
    np = [0] * (N+1)
    np[0] = 1
    rp = [0] * (M-N+1)
    rp[0] = 1
    # 팩토리얼을 dp로 구현
    for i in range(1, M+1):
        mp[i] = mp[i-1]*i
        if i <= (N):
            np[i] = np[i-1]*i
        if i <= (M-N):
            rp[i] = rp[i-1]*i
    # float 형으로 나와서 int형으로 교체 (왜 그런지는 모르겠음)
    ans = int(mp[-1]/(np[-1]*rp[-1]))
    print(ans)
