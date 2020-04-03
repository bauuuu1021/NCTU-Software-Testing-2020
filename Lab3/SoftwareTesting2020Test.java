import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MyPaypalService implements paypalService {
    public String doDonate() {
        return "This is a fake implementation";
    }
}

@ExtendWith(MockitoExtension.class)
class SoftwareTesting2020Test {

    SoftwareTesting2020 softwareTesting2020;
    Student student;

    @BeforeEach
    void create () {

        softwareTesting2020 = new SoftwareTesting2020();
        student = new Student();
    }

    @Test
    void test_a () throws InterruptedException {

        Date date = mock(Date.class);
        when(date.getWeekday()).thenReturn(4);  // return Wednesday
        softwareTesting2020.date = date;

        Hospital hospital = spy(Hospital.class);
        softwareTesting2020.hospital = hospital;

        System.out.println(softwareTesting2020.enterClass(student));

        verify(softwareTesting2020.hospital, never()).treatment(student);
    }

    @Test
    void test_b () throws InterruptedException {

        Date date = mock(Date.class);
        when(date.getWeekday()).thenReturn(5);  // return Thursday
        softwareTesting2020.date = date;

        Hospital hospital = spy(Hospital.class);
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                return null;
            }
        }).when(hospital).isolation(isA(Student.class));
        softwareTesting2020.hospital = hospital;

        String correctString = "After a long time treatment. The student can get out! ^__^";
        assertEquals(correctString, softwareTesting2020.enterClass(student));
    }

    @Test
    void test_c () throws InterruptedException {

        List<String> ids = Arrays.asList("0856001", "0856002", "0856003");
        Hospital hospital = spy(Hospital.class);
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                return null;
            }
        }).when(hospital).isolation(isA(Student.class));

        for (String id : ids) {
            student = new Student(id, 39);
            hospital.treatment(student);
        }

        assertEquals(ids, hospital.getLog());
    }

    @Test
    void test_d () {
        softwareTesting2020 = mock(SoftwareTesting2020.class);
        when(softwareTesting2020.getScore(isA(String.class))).thenReturn(70);

        System.out.println(softwareTesting2020.getScore(student.getStudentId()));
    }

    @Test
    void test_e () {
        MyPaypalService myPaypalService = new MyPaypalService();
        softwareTesting2020 = mock(SoftwareTesting2020.class);
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                MyPaypalService my = new MyPaypalService();
                return my.doDonate();
            }
        }).when(softwareTesting2020).donate(isA(paypalService.class));

        System.out.println(softwareTesting2020.donate(myPaypalService));
    }
}