# problem-Breaking-the-Records

1-Review:

Maria plays college basketball and wants to go pro. Each season she maintains a record of her play. She tabulates the number of times she breaks her season record for most points and least points in a game. Points scored in the first game establish her record for the season, and she begins counting from there.

For example, assume her scores for the season are represented in the array scores=[12,24,10,24].
Scores are in the same order as the games played. She would tabulate her results as follows:

`               Count                   `

 `Game  Score  Minimum  Maximum   Min Max`
 
 ` 0      12     12       12       0   0 `

 ` 1      24     12       24       0   1 `

 ` 2      10     10       24       1   1 `

 ` 3      24     10       24       1   1 `
 
 Given Maria's scores for a season, find and print the number of times she breaks her records for most and least points scored during the season.
 
 2-Input Format

The first line contains an integer n the number of games.
The remains lines contains input each score.

3-Output Format

Print two space-seperated integers describing the respective numbers of times her best (highest) score increased and her worst (lowest) score decreased.
