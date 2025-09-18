
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

