/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* removeNodes(ListNode* head) {

      ListNode* tempHead=head;
        int c=INT_MIN;
      vector<int> v;
      while(tempHead)
      { 
        v.push_back(tempHead->val);
        tempHead=tempHead->next;
      }  
      for(int i=v.size()-1;i>=0;i--)
      {
        c=max(c,v[i]);
        v[i]=c;
      }
      int i=0;
        tempHead=head;
        
        // while(i<v.size() && tempHead->val<v[i])
        // {
        //     i++;
        //     tempHead=tempHead->next;
        // }
        ListNode newHead(0);
        ListNode* prev = &newHead;
        while(i<v.size() && tempHead!=nullptr)
        {
            if(tempHead && tempHead->val >=v[i])
            {
                prev->next=tempHead;
                prev=tempHead;
            }
            i++;
            tempHead=tempHead->next;
        }
        prev->next=nullptr;
        return newHead.next;
      

    }
};

/*
5  2  13 3 8
13 13 13 8 8
*/