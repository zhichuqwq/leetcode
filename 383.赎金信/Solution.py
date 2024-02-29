class Solution:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        dict1 = Counter(magazine)
        for i in ransomNote:
            dict1[i] -= 1
            if dict1[i] < 0:
                return False
        return True
