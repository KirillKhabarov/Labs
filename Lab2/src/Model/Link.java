package Model;

class Link
{
    public int iData;              // data item
    public double dData;           // data item
    public Link next;              // next link in list
    // -------------------------------------------------------------
    public Link(int id, double dd) // constructor
    {
        iData = id;                 // initialize data
        dData = dd;                 // ('next' is automatically
    }                           //  set to null)
    // -------------------------------------------------------------
    public String displayLink()      // display ourself
    {
        return "{" + iData + ", " + dData + "} ";
    }
}  // end class Link
////////////////////////////////////////////////////////////////
class LinkList
{
    private Link first;            // ref to first link on list

    // -------------------------------------------------------------
    public LinkList()              // constructor
    {
        first = null;               // no links on list yet
    }
    // -------------------------------------------------------------
    public boolean isEmpty()       // true if list is empty
    {
        return (first==null);
    }
    // -------------------------------------------------------------
    // insert at start of list
    public void insertFirst(int id, double dd)
    {                           // make new link
        Link newLink = new Link(id, dd);
        newLink.next = first;       // newLink --> old first
        first = newLink;            // first --> newLink
    }
    // -------------------------------------------------------------
    public Link deleteFirst()      // delete first item
    {                           // (assumes list not empty)
        Link temp = first;          // save reference to link
        first = first.next;         // delete it: first-->old next
        return temp;                // return deleted link
    }
    // -------------------------------------------------------------
    public String display()
    {

        String str=new String();
        Link current = first;          // start at beginning
        while(current != null)         // until end of list,
        {
            str+=current.iData+":"+current.dData+" ";
            current = current.next;     // move to next link
        }
        return str;
    }

// -------------------------------------------------------------
}  // end class LinkList

