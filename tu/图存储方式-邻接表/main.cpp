#include <iostream>
#include <stdlib.h>
#include <string.h>
#include <stdio.h>
using namespace std;

struct node
{
    int data;
    struct node * next;
};

int main()
{
    ios::sync_with_stdio(false);

    int m, n;
    struct node * head[500001], *p, *temp;

    while(cin >> n >> m)
    {
        for(int i = 0; i < n; i++)
            head[i] = NULL;//��ʼ������ͷ����Ӧÿ���㶼��һ������

        for(int i = 0; i < m; i++)//�������㣬ȷ������
        {
            int u, v;
            cin >> u >> v;
            //������ĵ㻹û�н��������ʱ�򣬿����ڴ棬��������
            if(head[u] == NULL)
            {
                head[u] = (struct node *)malloc(sizeof(struct node));
                head[u]->data = v;
                head[u]->next = NULL;
            }
            //������ĵ��Ѿ��������ڴ潨��������ͨ������������ķ�������������
            else
            {
                temp = head[u]->next;
                p = (struct node *)malloc(sizeof(struct node));
                p->data = v;
                p->next = temp;
                head[u]->next = p;
            }
        }
        int q;
        cin >> q;
        for(int i = 0; i < q; i++)
        {
            int x, y;
            int flag = 0;
            cin >> x >> y;
            //����������û�н�������������ͨ
            if(head[x] == NULL)
                cout << "No" << endl;
            else
            {
                //�ӵ�ǰ�㿪ʼ��������������������������ݵ�ʱ��flag��ֵ����
                temp = head[x];
                while(temp != NULL)
                {
                    if(temp->data == y)
                    {
                        flag = 1;
                        break;
                    }
                    temp = temp->next;
                }
                if(flag == 1)
                    cout << "Yes" << endl;
                else
                    cout << "No" << endl;
            }
        }
    }
    return 0;
}

