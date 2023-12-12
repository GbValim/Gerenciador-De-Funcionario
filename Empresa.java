package trabalho;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class Empresa {
    private ArrayList<Funcionario> funcionarios = new ArrayList<>();

    public void cadastrarFuncionario(String nome, String cargo, double salario, Date dataAdmissao) {
        Funcionario novoFuncionario = new Funcionario(nome, cargo, salario, dataAdmissao);

        // Verificar se já existe um funcionário com o mesmo nome
        if (!funcionarioJaCadastrado(nome)) {
            funcionarios.add(novoFuncionario);
            System.out.println("Funcionário cadastrado com sucesso!");
        } else {
            System.out.println("Erro: Já existe um funcionário com o mesmo nome.");
        }
    }

    public void listarFuncionarios() {
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario.getNome() + " - " + funcionario.getCargo());
        }
    }

    public void atualizarInformacoes(String nome, String novoCargo, double novoSalario) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getNome().equals(nome)) {
                funcionario.setCargo(novoCargo);
                funcionario.setSalario(novoSalario);
                System.out.println("Informações atualizadas com sucesso!");
                return;
            }
        }
        System.out.println("Erro: Funcionário não encontrado.");
    }

    public void excluirFuncionario(String nome) {
        Iterator<Funcionario> iterator = funcionarios.iterator();
        while (iterator.hasNext()) {
            Funcionario funcionario = iterator.next();
            if (funcionario.getNome().equals(nome)) {
                iterator.remove();
                System.out.println("Funcionário excluído com sucesso!");
                return;
            }
        }
        System.out.println("Erro: Funcionário não encontrado.");
    }

    private boolean funcionarioJaCadastrado(String nome) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getNome().equals(nome)) {
                return true;
            }
        }
        return false;
    }
}

