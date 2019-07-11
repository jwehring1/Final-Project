import Add.AddPerson;
import Add.AddPersonFailMissingParameter;
import Delete.DeletePerson;
import Home.Navigate;
import Search.ListAllAddresses;
import Search.ListAllPeople;
import Search.SearchAddressAtStreet;
import Search.SearchPeopleAtAddress;
import Update.UpdatePerson;
import org.junit.Test;

public class All {
    @Test
    public void test()
    {
        AddPerson ap1 = new AddPerson();
        DeletePerson dp1 = new DeletePerson();
        Navigate n = new Navigate();
        ListAllAddresses l1 = new ListAllAddresses();
        ListAllPeople l2 = new ListAllPeople();
        SearchAddressAtStreet l3 = new SearchAddressAtStreet();
        SearchPeopleAtAddress l4 = new SearchPeopleAtAddress();
        UpdatePerson up1 = new UpdatePerson();
        ap1.test();
        up1.test();
        l4.test();
        l3.test();
        l2.Test();
        l1.Test();
        n.test();
        dp1.test();
    }
}
