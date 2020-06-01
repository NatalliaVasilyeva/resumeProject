import java.util.Objects;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        storage = null;
        storage = new Resume[10000];
    }

    void save(Resume r) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = r;
                break;
            }
        }
    }

    Resume get(String uuid) {
        for (Resume resume : storage) {
            if (Objects.equals(resume.uuid, uuid)) return resume;
            break;
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            if (Objects.equals(storage[i].uuid, uuid)) {
                Resume[] copy = new Resume[storage.length];
                System.arraycopy(storage, 0, copy, 0, i);
                System.arraycopy(storage, i + 1, copy, i, storage.length - i - 1);
                copy[copy.length - 1] = null;
                storage = copy;
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        int count=0;
        while (storage[count]!=null) {
            count++;
        }
        Resume[] copy = new Resume[count];
        System.arraycopy(storage, 0, copy, 0, count);
        return copy;
    }

    int size() {
        int count=0;
        while (storage[count]!=null) {
            count++;
        }
        return count;
    }
}
