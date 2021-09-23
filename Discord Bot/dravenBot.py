from riotwatcher import LolWatcher

key = 'RGAPI-1a261641-9444-48fb-897f-7e315ac00c5d'
watcher = LolWatcher(key)


def outputStats(summonerName):
    leagueplayer = watcher.summoner.by_name('euw1', summonerName)
    stats = watcher.league.by_summoner('euw1', leagueplayer['id'])

    #stats for solo duo ranked
    tier = stats[0]['tier']
    rank = stats[0]['rank']
    lp = stats[0]['leaguePoints']

    #stats for flex rank
    flexTier = stats[1]['tier']
    flexRank = stats[1]['rank']
    flexlp = stats[1]['leaguePoints']


    soloWins = stats[0]['wins']
    soloLosses = stats[0]['losses']

    soloWR = int((soloWins / (soloWins + soloLosses)) * 100)

    flexWins = stats[1]['wins']
    flexLosses = stats[1]['losses']

    flexWR = int((flexWins / (flexLosses + flexWins)) *100)

    print("solo/duo: ", tier, rank, lp, "LP \n winrate: ",soloWR,"%")
    print("\nflex: ", flexTier, flexRank, flexlp, "LP \n winrate: ",flexWR,"%")

username = "msye"

outputStats(username)

