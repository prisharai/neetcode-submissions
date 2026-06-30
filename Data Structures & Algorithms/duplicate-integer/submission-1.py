class Solution: 
    def hasDuplicate(self, nums: List[int]) -> bool:
        '''psuedocode logic: 
        - if element in nums not in hash set 'seen', add to hash map 
        - if element in nums in hash set 'seen', return true 
        - else return false 
        '''
        #1. BRUTE FORCE - O(n^2) time, O(1) space 
        '''for i in range (len(nums)):
            for j in range (i+1, len(nums)):
                if nums[i] == nums[j]:
                    return True 
        return False'''

        #2. SORTING - O(n log n) time, O(1) space
        '''nums.sort()
        for i in range(1, len(nums)):
            if nums[i] == nums[i-1]:
                return True 
        return False'''

        #3. HASH SET - O(n) time, O(n) space 
        seen = set()
        for element in nums: 
            if element in seen: 
                return True 
            seen.add(element)
        return False 


        