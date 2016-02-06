def poker(hands):
    scores = [(i, score(hand.split())) for i, hand in enumerate(hands)]
    winner = sorted(scores , key=lambda x:x[1])[-1][0]
    return hands[winner]

def score(hand):
    ranks = '23456789TJQKA'
    rcounts = {ranks.find(r): ''.join(hand).count(r) for r, _ in hand}.items()
    score, ranks = zip(*sorted((cnt, rank) for rank, cnt in rcounts)[::-1])
    if len(score) == 5:
        if ranks[0:2] == (12, 3): #adjust if 5 high straight
            ranks = (3, 2, 1, 0, -1)
        straight = ranks[0] - ranks[4] == 4
        flush = len({suit for _, suit in hand}) == 1
        '''no pair, straight, flush, or straight flush'''
        score = ([1, (3,1,1,1)], [(3,1,1,2), (5,)])[flush][straight]
    return score, ranks

def main():
    fp = open('p054_poker.txt')
    p1 = 0
    for i in fp.readlines():
        hand = [i[0:14],i[15:30]]
        if poker(hand) == i[0:14]:
            p1 += 1
    print p1

if __name__ == '__main__':
    main()