def solution(genres, plays):
    # 음악 dict
    play_num_sum_songs = {}
    play_num_and_id_songs = {}
    # 음악 장르 dict에 집어 넣기
    unique_genres = list(set(genres))
    for genre in unique_genres:
        play_num_sum_songs[genre] = 0
        play_num_and_id_songs[genre] = []
    # 음악 개수
    n = len(genres)
    # 장르별 음악 집어넣기
    for i in range(n):
        play_num_sum_songs[genres[i]] += plays[i]
        play_num_and_id_songs[genres[i]].append((plays[i],i))
    # 장르별 음악 합계 정렬
    sorted_songs_by_song_sum = sorted(play_num_sum_songs.items(), key = lambda x : x[1], reverse = True)
    # 장르 중 2개의 인기 앨범 2개 사용
    answer = []
    for genre, sum_song in sorted_songs_by_song_sum:
        sorted_songs_by_song_num = sorted(play_num_and_id_songs[genre], key = lambda x : x[0], reverse = True)
        cnt = 0
        for num, idx in sorted_songs_by_song_num:
            cnt += 1
            answer.append(idx)
            if cnt == 2:
                break
    return answer